package year2018;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @packageName: year2018
 * @Auther: likun
 * @Date: 2018/8/19 16:25
 * @Description:
 */
public class AtomicTest {

    public static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void increase () {
        atomicInteger.incrementAndGet();
    }

    private static final int THREAD_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i=0;i<THREAD_COUNT;i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0;i<1000;i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
            System.out.println(atomicInteger);
        }

//        while (Thread.activeCount() > 1) {
//            Thread.yield();
//        }
        System.out.println(atomicInteger);
    }
}
