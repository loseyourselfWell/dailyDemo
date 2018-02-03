package day1124;

/**
 * 工厂接口创建Person对象
 * @param <P>
 */
public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
