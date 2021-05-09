package threadpool.creating;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService threadpool = Executors.newScheduledThreadPool(10);
        threadpool.schedule(new Task(), 5, TimeUnit.SECONDS);
        //pool-1-thread-1
        threadpool.scheduleAtFixedRate(new Task(), 1, 3,TimeUnit.SECONDS);
//        pool-1-thread-1
//        pool-1-thread-1
//        pool-1-thread-2
//        pool-1-thread-1
//        pool-1-thread-3
    }
}
