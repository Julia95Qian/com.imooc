package threadpool.creating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Task());
        }
    }
}
//terminal输出
//        pool-1-thread-683
//        pool-1-thread-690
//        pool-1-thread-760
//        pool-1-thread-691
//        pool-1-thread-685