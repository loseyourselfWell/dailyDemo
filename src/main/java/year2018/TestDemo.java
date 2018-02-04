package year2018;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author likun
 * @version V1.0
 * @Title: year2018
 * @date 2018/1/15 13:43
 */
public class TestDemo {

    @Test
    public void enumTest(){
        List<Day0103> list = new ArrayList<>();
        Collections.sort(list, Comparator.naturalOrder());
        System.out.println(DemoEnum.ONE_DAT.getCode());
    }

    @Test
    public void testList(){
        List<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        for (String str : arrayList){
            if ("2".equals(str)){
                arrayList.remove(str);
            }
        }
        //System.out.println(arrayList.toString());
    }

    @Test
    public void dateTest(){
        LocalDate date = LocalDate.now();
        System.out.println(date);
        Date dateNew = new Date();
        System.out.println(dateNew);
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
////        String text = date.format(dateTimeFormatter);
////        System.out.println(text);
    }
}
