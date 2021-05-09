package threadpool.closing;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 演示关闭线程池
 */
public class ShutDown {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new ShutDownTask());
        }
        Thread.sleep(1500);

        List<Runnable> runnableList = executorService.shutdownNow(); //在队列中但还未被执行的线程

        // awaitTermination方法测试
//        executorService.shutdown();
//        boolean isStop= executorService.awaitTermination(7, TimeUnit.SECONDS); //线程阻塞
//        System.out.println("暂停7s后线程池是否停止:"+isStop);

        // isShutdown，isTerminated方法测试
//        System.out.println("线程池关闭前isShutDown:"+executorService.isShutdown());
//        executorService.shutdown();
//        System.out.println("线程池关闭后isShutDown:"+executorService.isShutdown()); //是否关闭指示
//        System.out.println("线程池关闭后isTerminated:"+executorService.isTerminated()); //是否关闭指示
//        Thread.sleep(10000);
//        System.out.println("10a后isTerminated:"+executorService.isTerminated());
//        executorService.execute(new ShutDownTask()); // 异常报错
    }
}
class ShutDownTask implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(Thread.currentThread().getName()+"被中断了");
        }

    }
}
