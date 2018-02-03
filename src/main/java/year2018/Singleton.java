package year2018;

public class Singleton {

    //private static Singleton singleton = new Singleton();

    private Singleton(){

    }

    private static Singleton singleton = null;

    /**
     * 静态工厂
     * @return
     */
    public static Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

}
