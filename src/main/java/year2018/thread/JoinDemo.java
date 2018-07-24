package year2018.thread;

/**
 * @package year2018.thread
 * @Author: kun.li
 * @Date: 2018/7/11
 */
public class JoinDemo {

    public static void main(String[] args) {
        Thread previousThread = Thread.currentThread();
        for (int i=0;i<10;i++) {
            Thread curThread = new JoinThread(previousThread);
            curThread.start();
            previousThread = curThread;
        }

    }

    static class JoinThread extends Thread {

        private Thread thread;

        public JoinThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
                System.out.println(thread.getName() + " terminated.");
            } catch (Exception e) {
                e.printStackTrace();
            }
            super.run();
        }
    }
}
