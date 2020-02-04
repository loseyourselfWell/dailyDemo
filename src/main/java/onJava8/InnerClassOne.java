package onJava8;

public class InnerClassOne {

    public void f() {
        System.out.println("InnerClassOne.f()");
    }

    public class InnerClass {
        public InnerClassOne something() {
            return InnerClassOne.this;
        }
    }

//    public InnerClass inner() {
//        return new InnerClass();
//    }

    public static void main(String[] args) {
        InnerClassOne innerClassOne = new InnerClassOne();
        InnerClassOne.InnerClass inner = innerClassOne.new InnerClass();
        inner.something().f();
    }

}
