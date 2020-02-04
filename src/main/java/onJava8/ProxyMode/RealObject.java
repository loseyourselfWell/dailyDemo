package onJava8.ProxyMode;

public class RealObject implements SomeInterface {
    @Override
    public void something() {
        System.out.println("something");
    }

    @Override
    public void somethingElse(String info) {
        System.out.println(info);
    }
}
