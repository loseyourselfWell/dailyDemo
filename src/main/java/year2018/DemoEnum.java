package year2018;

/**
 * @author likun
 * @version V1.0
 * @Title: year2018
 * @date 2018/1/15 13:39
 */
public enum DemoEnum {
    ONE_DAT("001","第一天"),
    TWO_DAT("002","第二天");

    private String code;
    private String name;

    DemoEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
