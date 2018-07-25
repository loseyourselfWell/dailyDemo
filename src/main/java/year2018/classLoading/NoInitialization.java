package year2018.classLoading;

/**
 * @packageName: year2018.classLoading
 * @Auther: Administrator
 * @Date: 2018/7/21 21:04
 * @Description:
 */
public class NoInitialization {

    public static void main(String[] args) {
        System.out.println(SuperClass.HELLO_WORLD);
//        SuperClass[] sca = new SuperClass[10];
    }
}
