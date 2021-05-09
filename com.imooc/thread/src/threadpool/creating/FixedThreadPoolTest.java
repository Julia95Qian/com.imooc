package threadpool.creating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示 newFixedThreadPool
 * */
public class FixedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(int i=0;i<100;i++){
            executorService.execute(new Task());
        }
    }
}
class Task implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
//terminal输出
//        pool-1-thread-1
//        pool-1-thread-2
//        pool-1-thread-4
//        pool-1-thread-3
