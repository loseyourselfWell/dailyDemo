package onJava8.ProxyMode;

import java.lang.reflect.Proxy;

public class Consumer {

    static void get(SomeInterface someInterface) {
        someInterface.something();
        someInterface.somethingElse("banana");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        get(realObject);
        SomeInterface proxyInstance = (SomeInterface)Proxy.newProxyInstance(SomeInterface.class.getClassLoader(),
                new Class[]{SomeInterface.class}, new DynamicProxyHandler(realObject));
        /*
         * jvm会在底层替换掉class文件，从而转向自己定义的代理类
         */
        get(proxyInstance);
    }
}
