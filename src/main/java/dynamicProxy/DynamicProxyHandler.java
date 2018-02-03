package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

public class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }


    //传递代理对象
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-------- proxy:"+proxy.getClass() + "--------method:"+method+"--------args:"+args);
        try {
            Objects.requireNonNull(args);
            for (Object arg : args) {
                System.out.println("----" + arg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return method.invoke(proxied,args);
    }
}
