package year2018;

import org.apache.commons.lang3.StringUtils;

/**
 * try catch finally Demo
 * @author likun
 * @version V1.0
 * @Title: year2018
 * @date 2018/3/22 10:19
 */
public class TryCatchFinallyTest {

    public static final String testOne(){
        String str = StringUtils.EMPTY;
        try {
            str = "try";
            return str;
        }catch (Exception e) {
            str = "catch";
            return str;
        }finally {
            str = "finally";
            return str;
        }
    }

    public static void main(String[] args) {
        /**
         * 详解
         * 1.finally块中避免使用return语句
         * 2.try catch finally中如果finally中有return则返回finally中,否则返回try/catch中的return语句
         */
        System.out.println(testOne());
    }
}
