package simpleProxy;

/**
 * 测试类
 */
public class SimplleProxyDemo {
    public static void consumer(Interface iface){
        iface.somethingElse("lk");
        iface.doSomething();
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        //真正的类被动态代理类代理，先执行再调用实际类
        consumer(new SimpleProxy(new RealObject()));
    }
}
