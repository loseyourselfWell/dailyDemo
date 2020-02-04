package onJava8.annotation;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 注解处理器
 */
public class UserCaseReflect {

    public static void reflectUserCase(List<Integer> UserCaseIdList, Class<?> c) {
        for (Method method : c.getDeclaredMethods()) {
            UserCase userCase = method.getDeclaredAnnotation(UserCase.class);
            // UserCaseTwo userCase = method.getDeclaredAnnotation(UserCaseTwo.class);
            if (Objects.nonNull(userCase)) {
                UserCaseIdList.remove(userCase.id());
            }
        }

    }

    public static void main(String[] args) {
        List<Integer> userCaseIdList = IntStream.range(47, 50).boxed().collect(Collectors.toList());
        reflectUserCase(userCaseIdList,PasswordUtils.class);
    }
}
