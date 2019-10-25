package year2019.strategyMethod;

/**
 * 策略模式
 * @package year2019.strategyMethod
 * @Author: likun
 * @Date: 2019/8/31
 */
@FunctionalInterface
public interface ValidationStrategy {

    boolean execute(String s);
}
