package year2018;

/**
 * 静态分派
 * @packageName: year2018
 * @Auther: likun
 * @Date: 2018/8/4 16:13
 * @Description:
 */
public class StaticDispatch {

    static abstract class Human {

    }

    static class Man extends Human {

    }

    static class Woman extends Human {

    }

    public void sayHello (Human guy) {
        System.out.println("hello,human");
    }

    public void sayHello (Man guy) {
        System.out.println("hello,Man");
    }

    public void sayHello (Woman guy) {
        System.out.println("hello,Woman");
    }

    public static void main(String[] args) {
        Man man = new Man();
        Human woman = new Woman();
        StaticDispatch dispatch = new StaticDispatch();
        dispatch.sayHello(man);
        dispatch.sayHello(woman);

    }

}
