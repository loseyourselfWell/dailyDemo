package onJava8;

public class ClassInitOne {



    public static void main(String[] args) throws ClassNotFoundException {
        ClassInitOne initOne = new ClassInitOne();
        System.out.println(one.ONE_TEMP);
        System.out.println(two.TWO_TEMP);
    }

}

class one {
    static final int ONE_TEMP = 47;

    public one() {
        System.out.println("one init");
    }

    static {
        System.out.println("Initializing one");
    }

}

class two {

    // 调用需要初始化类
    static int TWO_TEMP = 129;

    public two() {
        System.out.println("two init");
    }

    static {
        System.out.println("Initializing two");
    }

}
