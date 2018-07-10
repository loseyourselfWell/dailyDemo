package year2018.adapterModel;

/**
 * @package year2018.adapterModel
 * @Author: kun.li
 * @Date: 2018/7/3
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("gobble gobble!");
    }
}
