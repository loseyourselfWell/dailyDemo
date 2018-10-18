package year2018;

/**
 * 软件状态
 */
public enum SoftwareStatusEnum {
    CREATE(10,"创建"),
    OPENING(20,"开通中"),
    OPENED(30,"已开通");

    private final int key;
    private final String value;

    SoftwareStatusEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static SoftwareStatusEnum valueOf(int initValue){
        for (SoftwareStatusEnum num : values()) {
            if (num.getKey() == initValue) {
                return num;
            }
        }

        throw new IllegalArgumentException("no such enum object for the id: " + initValue);
    }
}
