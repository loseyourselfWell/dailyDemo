package onJava8;

public interface InterfaceOne {

    default void getName() {
        System.out.println("getName");
    }

    String getStr();

    static void staticMethod() {
        System.out.println("static method");
    }
}
