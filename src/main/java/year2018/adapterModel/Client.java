package year2018.adapterModel;

/**
 * @package year2018.adapterModel
 * @Author: kun.li
 * @Date: 2018/7/3
 */
public class Client {
    public static void main(String[] args) {
        Turkey turkey = new WildTurkey();
        Duck duck = new TurkeyAdapter(turkey);
        duck.quack();
    }
}
