package year2018;

import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import year2018.bean.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author likun
 * @version V1.0
 * @Title: year2018
 * @date 2018/1/15 13:43
 */
public class TestDemo extends TestCase {

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
        arrayList.add("3");
        int pageSizeEnd = 20;
            if (pageSizeEnd > arrayList.size()) {
                pageSizeEnd = arrayList.size();
            }
            if (3 <= arrayList.size()) {
                List<String> subList = arrayList.subList(0, pageSizeEnd);
                System.out.println(JSON.toJSONString(subList));
            }
        //System.out.println(arrayList.toString());
    }

    @Test
    public void dateTest(){
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
//        LocalDate setDateBySelf = LocalDate.of(2018, 02, 28);
//        System.out.println(setDateBySelf);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String text = dateTimeFormatter.format(dateTime);
        System.out.println(text);
        // 取本月第1天
        LocalDate firstDayOfThisMonth = date.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate secondDayOfThisMonth = date.withDayOfMonth(2);
        // 取本月最后一天，再也不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = date.with(TemporalAdjusters.lastDayOfMonth());
        // 取2015年1月第一个周一，这个计算用Calendar要死掉很多脑细胞：
        LocalDate firstMondayOf2015 = LocalDate.parse("2015-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstDayOfThisMonth + "==="+secondDayOfThisMonth+"==="+lastDayOfThisMonth+"==="+firstMondayOf2015);
        long time = System.currentTimeMillis();
        System.out.println(time);
        Instant instant = Instant.now();
        System.out.println(instant);
    }

    @Test
    public void TestOption(){
        Optional<String> name = null;
        Assert.assertEquals(true,name.isPresent());

        String time = "2018-02-08 01:20";
    }

    @Test
    public void ReflectTest() throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("year2018.bean.Car");

        Constructor cons =  clazz.getDeclaredConstructor((Class[]) null);
        Car car = (Car)cons.newInstance();

        Method setBrand = clazz.getMethod("setBrand",String.class);
        setBrand.invoke(car,"奇瑞QQ");

        Method setColor = clazz.getMethod("setColor",String.class);
        setColor.invoke(car,"red");

       //car.introduce();
    }

    @Test
    @NeedTest
    public void SpringDemo(){
        Class clazz = ForumService.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            NeedTest need = method.getAnnotation(NeedTest.class);
            if (need.value()){
                System.out.println(method.getName() + "需要测试");
            }else {
                System.out.println(method.getName() + "不需要测试");
            }
        }
    }

    @Test
    public void testProtoType() {
        ConcreteProtoType concreteProtoType = new ConcreteProtoType("abc");
        ProtoType clone = concreteProtoType.myClone();
        System.out.println(clone.toString());
    }

//    @Test
//    public void testSelectionSort () {
//        int [] arr = {3, 4,2, 45, 65, 33, 12,15};
//
//        for (int i=0;i<arr.length-1;i++) {
//            int k = i;
//            for (int j=k+1;j<arr.length;j++) {
//                // 如果后面有元素比需要比较的元素小,则交换
//                if (arr[j] < arr[k] ) {
//                    k = j;
//                }
//            }
//            if (i != k) {
//                int temp = arr[k];
//                arr[k] = arr[i];
//                arr[i] = temp;
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//    }





    class Value {
        int val;
    }

    @Test
    public void numeric() {
        int i1 = 3;
        int i2;
        i2 = 4;
        System.out.print("i1==" + i1);
        System.out.println(" but i2==" + i2);
        Value v1 = new Value();
        v1.val = 5;
        Value v2 = v1;
        v2.val = 6;
        System.out.print("v1.val==" + v1.val);
        System.out.println(" and v2.val==" + v2.val);
    }

    @Test
    public void randomTest() {

        ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<>();
        map.put("1",1);
        System.out.println(map.size());
    }


}
