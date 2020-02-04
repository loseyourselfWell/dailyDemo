package onJava8;

public class InnerClassTwo {

    InterfaceOne getInterface() {

        return new InterfaceOne() {

            final String x = "anonymous inner class";

            @Override
            public String getStr() {
                return x;
            }
        };
    }

    public class getInterfaceLocal implements InterfaceOne {

        getInterfaceLocal() {
            System.out.println("constructor init");
        }

        @Override
        public String getStr() {
            return "local inner class";
        }
    }

    public static void main(String[] args) {
        InnerClassTwo innerClassTwo = new InnerClassTwo();
        System.out.println(innerClassTwo.getInterface().getStr());
        System.out.println(innerClassTwo.new getInterfaceLocal().getStr());
    }
}
