package dynamicProxy;

import java.lang.reflect.Proxy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDynamicProxy {
    private static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("lk");
    }

    public static void main(String[] args) throws ParseException {
        RealObject real = new RealObject();
        consumer(real);

        //创建动态代理 需要一个类加载器，一个需要代理的接口列表 以及一个InvocationHandler的实现类
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),new Class[]{Interface.class},new DynamicProxyHandler(real));
        consumer(proxy);

    }
}
