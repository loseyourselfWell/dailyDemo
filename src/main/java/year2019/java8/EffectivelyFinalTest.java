package year2019.java8;

/**
 * @package year2019.java8
 * @Author: likun
 * @Date: 2019/12/16
 */
public class EffectivelyFinalTest {



    private Foo foo;


    public EffectivelyFinalTest(Foo foo) {
        this.foo = foo;
    }


//    void m4(int x) {
//        int y;
//        if (x < 1) {
//            y = 1;
//        } else {
//            y = 2;
//        }
//        foo(() -> x+y);
//    }



}
