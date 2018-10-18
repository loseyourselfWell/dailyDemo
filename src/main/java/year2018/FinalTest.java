package year2018;

/**
 * @package year2018
 * @Author: likun
 * @Date: 2018/8/31
 */
public class FinalTest {

    public static void main(String[] args) {
        String str = "aaa";
        FinalTest test = new FinalTest();
        test.checkFinalVariable(str);
        str = str + "bbb";
        test.checkFinalVariable(str);
    }



     private void checkFinalVariable(final String str) {
         System.out.println(str);
    }
}
