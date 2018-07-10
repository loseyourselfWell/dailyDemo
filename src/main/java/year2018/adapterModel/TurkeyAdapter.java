package year2018.adapterModel;

/**
 * @package year2018.adapterModel
 * @Author: kun.li
 * @Date: 2018/7/3
 */
public class TurkeyAdapter implements Duck {

    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }
    @Override
    public void quack() {
        turkey.gobble();
    }
}
