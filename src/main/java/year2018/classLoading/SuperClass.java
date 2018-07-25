package year2018.classLoading;

public class SuperClass {
    static {
        System.out.println("SuperClass init !");
    }

    /**
     * static 修饰的变量只是全局静态的意思并不代表常量
     */
    public static int value = 123;

    private SuperClass[] superClasses;

    /**
     * final代表的是不可改变的常量,会在jvm启动时加载到常量池中不需要加载类
     */
    public static final String HELLO_WORLD = "Hello_world !";
}

