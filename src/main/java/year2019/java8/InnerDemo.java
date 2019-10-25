package year2019.java8;

/**
 * @package year2019.java8
 * @Author: likun
 * @Date: 2019/8/25
 */
public class InnerDemo {

    public final int value = 4;
    public void doIt() {
        int value = 6;
        Runnable r = new Runnable(){
            final int value = 5;
            public void run(){
                int value = 10;
                System.out.println(this.value);
            }
        };
        System.out.println(value);
        r.run();
    }
    public static void main(String...args) {
        InnerDemo m = new InnerDemo();
        m.doIt();
    }
}
