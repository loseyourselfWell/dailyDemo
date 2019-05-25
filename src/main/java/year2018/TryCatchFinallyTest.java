package year2018;

import year2018.bean.Car;

import java.util.Comparator;

/**
 * try catch finally Demo
 * @author likun
 * @version V1.0
 * @Title: year2018
 * @date 2018/3/22 10:19
 */
public class TryCatchFinallyTest implements Comparable{

    private Object object;

    static Comparator<Object> hashCodeOrder = Comparator.comparingInt(Object::hashCode);

    public int ComPareTo(Object o, Object object) {
        return hashCodeOrder.compare(o,object);
    }

    @Override
    public int compareTo(Object o) {
        return hashCodeOrder.compare(object,o);
    }
}
