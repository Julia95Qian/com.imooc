package threadpool.creating;
/**
 *
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VariableThreadPool {
    public static void main(String[] args) {
        new VariableThreadPool().project(5);
        new VariableThreadPool().project(50);
        new VariableThreadPool().project(150);
        new VariableThreadPool().project(5, 5, 2);
    }

    public void project(int nums) {
        if (nums < 10) {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            for (int i = 0; i < nums; i++) {
                executorService.execute(new EngineerTask());
            }
        } else if (nums >= 10 && nums < 100) {
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            for (int i = 0; i < nums; i++) {
                executorService.execute(new EngineerTask());
            }
        } else if (nums > 100) {
            ExecutorService executorService = Executors.newCachedThreadPool();
            for (int i = 0; i < nums; i++) {
                executorService.execute(new EngineerTask());
            }
        }
    }

    public void project(int nums, int mon, int interval) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(nums);
        System.out.println("5支施工队5天后每隔2天维护一次");
        executorService.scheduleAtFixedRate(new EngineerTask(), mon, interval, TimeUnit.SECONDS);
    }
}

class EngineerTask implements Runnable {
    @Override
    public void run() {
        System.out.println("工程队" + Thread.currentThread().getName() + "正在施工");
    }
}

