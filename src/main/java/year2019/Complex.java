package year2019;

/**
 * 不可变类(提供公有静态工厂方法)
 * @package year2019
 * @Author: likun
 * @Date: 2019/4/23
 */
public class Complex {

    private final String name;

    private final Integer value;

    private Complex(String name,Integer value) {
        this.name = name;
        this.value = value;
    }

    public static Complex ComplexFactory(String name,Integer value) {
        return new Complex(name,value);
    }
}
