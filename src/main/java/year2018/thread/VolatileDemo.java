package year2018.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile并不能保证原子性
 * @package year2018.thread
 * @Author: kun.li
 * @Date: 2018/7/11
 */
public class VolatileDemo {
    //public  AtomicInteger inc = new AtomicInteger();
    private volatile int inc = 0;

    public void increase() {
        //inc.getAndIncrement();
        inc++;
    }

    public static void main(String[] args) {
        final VolatileDemo test = new VolatileDemo();
        for(int i=0;i<10;i++){
            new Thread(() -> {
                for(int j=0;j<1000;j++)
                    test.increase();
            }).start();
        }

        while(Thread.activeCount()>2) {
            Thread.yield();//保证前面的线程都执行完
        }
        System.out.println(test.inc);
    }
}
