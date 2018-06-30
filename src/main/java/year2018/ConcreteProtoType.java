package year2018;

/**
 * 原型demo
 * @package year2018
 * @Author: kun.li
 * @Date: 2018/6/29
 */
public class ConcreteProtoType extends ProtoType {

    private String filed;

    public ConcreteProtoType(String filed) {
        this.filed = filed;
    }
    @Override
    ProtoType myClone() {
        return new ConcreteProtoType(filed);
    }

    public String toString() {
        return filed;
    }
}
