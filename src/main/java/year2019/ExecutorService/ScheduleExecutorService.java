package year2019.ExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @package year2019.ExecutorService
 * @Author: likun
 * @Date: 2019/9/23
 */
public class ScheduleExecutorService {

    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);


    public static void main(String[] args) {
        for (int i=0;i<5;++i) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在执行。。。");
            });
            executorService.execute(thread);
        }

        executorService.shutdown();
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在执行。。。");
        }
    }

}
