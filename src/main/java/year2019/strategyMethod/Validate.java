package year2019.strategyMethod;

/**
 * @package year2019.strategyMethod
 * @Author: likun
 * @Date: 2019/8/31
 */
public class Validate {

    private ValidationStrategy validationStrategy;

    public Validate(ValidationStrategy validationStrategy) {
        this.validationStrategy = validationStrategy;
    }

    public static void main(String[] args) {

        Validate validate = new Validate((String s) -> s.matches("[a-z]+"));
        boolean one = validate.validationStrategy.execute("111");
        System.out.println(one);
        Validate validate2 = new Validate(new IsNumeric());
        boolean two = validate2.validationStrategy.execute("111");
        System.out.println(two);
    }
}
