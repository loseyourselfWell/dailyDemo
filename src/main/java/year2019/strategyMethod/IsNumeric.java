package year2019.strategyMethod;

/**
 * @package year2019.strategyMethod
 * @Author: likun
 * @Date: 2019/8/31
 */
public class IsNumeric implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
