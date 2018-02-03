package day1124;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import sun.security.krb5.SCDynamicStoreConfig;

import java.math.BigDecimal;
import java.util.*;
import java.util.zip.Adler32;

public class LearnFour {

    @Test
    public void  test(){
        List<String> linkedList = new LinkedList<>();
        linkedList.add("2");
        linkedList.add("da");
        linkedList.add("de");
        linkedList.add(2,"bb");

        //lambda 表达式遍历集合
        linkedList.forEach(linked-> System.out.println(linked));
        System.out.println(Arrays.toString(linkedList.toArray()));

        Map<String,Object> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);
        map.put("D", 40);
        map.put("E", 50);
        map.put("F", 60);
        map.forEach((k,v)-> System.out.println("key"+k+"============value"+v));
        for (Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey());

        }
        String[] arr = {"1","2","9"};
        if (ArrayUtils.contains(arr,"2")){
            System.out.println(111);
        }
    }

    @Test
    public void bigDecimalTest(){
        int dou = 12345691;
        System.out.println(dou);
        String d = "12.356";
        //double Double = 12345691;
        Double.valueOf(d);
        System.out.println(d);
    }

    @Test
    public void ListTest(){
        List<String> arrayList = new ArrayList<>(10);
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("2");
        arrayList.add("2");
        arrayList.add("2");
        arrayList.add("2");
        arrayList.add("2");
        arrayList.add("2");
        arrayList.add("2");
        arrayList.add("2");
        arrayList.add("2");
        arrayList.add("2");
        System.out.println(arrayList.toString());
    }

}
