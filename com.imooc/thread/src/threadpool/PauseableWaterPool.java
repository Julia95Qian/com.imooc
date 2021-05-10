package threadpool;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PauseableWaterPool extends ThreadPoolExecutor {

    private boolean isPaused;
    private final ReentrantLock lock = new ReentrantLock();
    private Condition unpaused = lock.newCondition();

    public PauseableWaterPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public PauseableWaterPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public PauseableWaterPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public PauseableWaterPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }
    @Override
    protected void beforeExecute(Thread t,Runnable r){
        super.beforeExecute(t, r);
        lock.lock();
        try {
            while (isPaused) {
                unpaused.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    private void pause() {
        lock.lock();
        try {
            isPaused = true;
        } finally {
            //释放锁
            lock.unlock();
            ;
        }
    }

    public void resume(){
        lock.lock();
        try {
            //唤醒全部
            isPaused=false;
            unpaused.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        PauseableWaterPool pauseableWaterPool = new PauseableWaterPool(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("正在放水");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("启动强制停水");
                    e.printStackTrace();
                }
            }

        };
        System.out.println("上班，水池放入1000吨水");
        for (int i = 0; i < 100; i++) {
            pauseableWaterPool.execute(runnable);
        }
        Thread.sleep(200);
        pauseableWaterPool.pause();
        System.out.println("中午，水池被暂停。还剩" + pauseableWaterPool.getQueue().size() + "吨水");
        System.out.println("暂停放水");
        Thread.sleep(200);
        pauseableWaterPool.resume();
        System.out.println("下午，水池开始放水");
        Thread.sleep(200);
        pauseableWaterPool.shutdown();
        System.out.println("下午6点，开始停水，10s内强制停水");
        if(pauseableWaterPool.isShutdown()){
            System.out.println("开始停水正常");
        }
        boolean isStop = pauseableWaterPool.awaitTermination(100, TimeUnit.MILLISECONDS);
        if(isStop){
            System.out.println("停水正常，水池没水了");
        }else{
            pauseableWaterPool.shutdownNow();
            System.out.println("启动强制停水");
            System.out.println("水池还剩" + pauseableWaterPool.getQueue().size() + "吨水");
        }
    }
}
