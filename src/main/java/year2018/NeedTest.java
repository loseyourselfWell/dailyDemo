package year2018;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 简单的注解类
 * 作用范围为运行期
 * 作用类型为方法
 * @author likun
 * @version V1.0
 * @Title: year2018
 * @date 2018/3/14 16:30
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NeedTest {
    boolean value() default true;
}
