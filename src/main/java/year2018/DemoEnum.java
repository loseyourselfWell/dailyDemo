package year2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author likun
 * @version V1.0
 * @Title: year2018
 * @date 2018/1/15 13:39
 */
public enum DemoEnum {
    ONE_DAT(1,"第一天"),
    TWO_DAT(2,"第二天");

    private final int code;
    private final String name;

    DemoEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static List<Integer> getCatalogLevelList() {
        List<Integer> list = new ArrayList<>();
        list.add(ONE_DAT.code);
        list.add(TWO_DAT.code);
        return list;
    }

    public static void main(String[] args) {
        for (DemoEnum demo : DemoEnum.values()) {
            System.out.println(demo.getCode());
        }
        System.out.println(Arrays.toString(getCatalogLevelList().toArray()) );
    }
}
