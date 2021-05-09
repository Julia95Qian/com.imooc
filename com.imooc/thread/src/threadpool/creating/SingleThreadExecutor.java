package threadpool.creating;
/**
 *  只有一个线程池
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i=0;i<100;i++){
            executorService.execute(new Task());
        }
    }
}
//terminal输出
//        pool-1-thread-1
//        pool-1-thread-1
//        pool-1-thread-1