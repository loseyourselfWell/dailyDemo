package onJava8;

public class Plus {
    public int sum(int i) {
        if (i == 1) {
            return 1;
        }
        return i + sum(i - 1);
    }
    public static void main(String[] args) {
        Plus plus = new Plus();
        System.out.println("计算结果：" + plus.sum(100) + "!");
    }


}
