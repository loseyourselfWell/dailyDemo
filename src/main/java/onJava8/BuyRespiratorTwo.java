package onJava8;

public class BuyRespiratorTwo {

    private static final int moreRespirator = 9;

    int count = 0;
    int total = 0;
    // 10
    public int totalRespirator(int i) {
        i--;
        count++;
        if (total == 70) {
            return count;
        } else {
            total = moreRespirator + totalRespirator(i);
        }
        return 0;
    }

    public static void main(String[] args) {
        BuyRespiratorTwo buyRespirator = new BuyRespiratorTwo();
        System.out.println(buyRespirator.totalRespirator(10));
    }

}
