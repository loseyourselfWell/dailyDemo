package onJava8.annotation;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 注解测试类
 */
public class PasswordUtils {

    @UserCase(id = 47, value =
            "Passwords must contain at least one numeric")
    @NotNull
    public boolean validatePassword(String passwd) {
        return (passwd.matches("\\w*\\d\\w*"));
    }
    @UserCase(id = 48)
    public String encryptPassword(String passwd) {
        return new StringBuilder(passwd)
                .reverse().toString();
    }
    @UserCase(id = 49, value =
            "New passwords can't equal previously used ones")
    public boolean checkForNewPassword(
            List<String> prevPasswords, String passwd) {
        return !prevPasswords.contains(passwd);
    }
}
