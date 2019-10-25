package year2019;

/**
 * @package year2019
 * @Author: likun
 * @Date: 2019/4/29
 */
public interface DefaultInterface {

    void getName();

    /**
     * 缺省方法  子类可以不覆盖
     */
    default void getValue() {

    }
}
