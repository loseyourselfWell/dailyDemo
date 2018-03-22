package year2018;

/**
 * 生产者,消费者最基本的演示
 * @author likun
 * @version V1.0
 * @Title: year2018
 * @date 2018/2/26 15:15
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Info info = new Info();
        new Thread(new Producer(info)).start();
        new Thread(new Customer(info)).start();
    }

}

class Info{
    private String title;
    private String content;
    /**
     * true :表示可以生产,但是不可以取走
     * false:表示可以取走,但是不可以生产
     */
    private boolean flag = true;
    synchronized void set(String title, String content){
        if (!this.flag){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title = title;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = content;
        this.flag = false;
        super.notify();
    }

    synchronized void get(){
        if (this.flag){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.title + "---" + this.content);
        this.flag = true;
        super.notify();
    }
}

/**
 * 生产者
 */
class Producer implements Runnable{
    private Info info;
    Producer(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (i % 2 == 0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.info.set("大飞","傻屌一个");
            }else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.info.set("袁明","怕是个智障");
            }
        }
    }
}

/**
 * 消费者
 */
class Customer implements Runnable {
    private Info info;
    Customer(Info info) {
        this.info = info;
    }


    @Override
    public void run() {
        for (int i=0;i<100;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.info.get();
        }
    }
}