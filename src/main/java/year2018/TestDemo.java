package year2018;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import year2018.bean.Car;
import year2018.thread.Node;
import year2019.*;
import year2019.java8.Dish;

import javax.annotation.Nonnull;
import javax.validation.constraints.Null;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * @author likun
 * @version V1.0
 * @Title: year2018
 * @date 2018/1/15 13:43
 */

@Slf4j
public class TestDemo {

    @Test
    public void enumTest() {

    }

    @Test
    public void testList() {
        List<Dish> dishList = new ArrayList<>();

        dishList.add(new Dish("111", true, 300, Dish.Type.FISH));
//        arrayList.add("1");
//        arrayList.add("2");
//        arrayList.add("3");
        List<Integer> integerList = dishList.parallelStream().filter(d -> {
            System.out.println("filtering : " + d.getName());
            return d.getCalories() < 400;
        })
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());

    }

    @Test
    public void streamTest() {
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        List<String> strList = streamOfwords
                .map(world -> world.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(strList));

        List<Integer> numberList = Lists.newArrayList(1, 3, 4, 5, 6);
        int total = numberList.parallelStream()
                .mapToInt(num -> num).reduce(1, (a, b) -> a * b);
        System.out.println(total);

        List<Dish> dishList = new ArrayList<>();
        dishList.add(new Dish("111", true, 300, Dish.Type.FISH));
        dishList.add(new Dish("222", true, 400, Dish.Type.MEAT));


        String collect = dishList.parallelStream()
                .map(Dish::getName)
                .collect(Collectors.joining(","));

        System.out.println(collect);

        Stream<int[]> stream = IntStream.range(1, 100).boxed()
                .flatMap(a -> IntStream.range(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );
        stream.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
    }


    private void forEach(String t) {
        System.out.println(t);
    }

    @Test
    public void dateTest() {
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
        System.out.println(firstDayOfThisMonth + "===" + secondDayOfThisMonth + "===" + lastDayOfThisMonth + "===" + firstMondayOf2015);
        long time = System.currentTimeMillis();
        System.out.println(time);
        Instant instant = Instant.now();
        System.out.println(instant);
    }

    @Test
    public void TestOption() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        Integer integer = list.stream().filter(d -> d > 2).findAny().orElse(1);
        System.out.println(integer);
        Map<String, Object> map = new HashMap<>();
        map.put("key", null);
        Optional<Object> value = Optional.ofNullable(map.get("key"));
        Optional<String> stringOptional = Optional.empty();
        list.stream().findAny().orElse(2);
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    @Test
    public void ReflectTest() throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("year2018.bean.Car");

        Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
        Car car = (Car) cons.newInstance();

        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "奇瑞QQ");

        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "red");

        //car.introduce();
    }

    @Test
    @NeedTest
    public void SpringDemo() {
        Class clazz = ForumService.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            NeedTest need = method.getAnnotation(NeedTest.class);
            if (need.value()) {
                System.out.println(method.getName() + "需要测试");
            } else {
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
        long before = System.currentTimeMillis();
        for (int i = 0; i < 10000000; ++i) {
            //System.out.println(i);
        }
        long after = System.currentTimeMillis();
        System.out.println(after - before);
        long before2 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            //System.out.println(i);
        }
        long after2 = System.currentTimeMillis();
        System.out.println(after2 - before2);
        System.out.println(Boolean.valueOf(true));
        BuilderDemo builderDemo = new BuilderDemo.Builder("aaa", 23).agentName("def").build();
    }

    @Test
    public void snowTest() {
        log.info("ddd");
    }


    @Test
    public void rebaseTest() {
        log.info("snow");
    }

    @Test
    public void oneMoreTest() {
        Date date = new Date();
        System.out.println(date);
        log.info("one more");
    }


    @Test
    public void CASTest() {

        AtomicBoolean locked = new AtomicBoolean(true);

        System.out.println(locked.compareAndSet(false, true));
    }

    @Test
    public void ObjectTest() {
        Car car = new Car();
        setColor(car);
        System.out.println(JSON.toJSONString(car));
    }

    private void setColor(Car car) {
//        car.setBrand("jili");
////        car.setColor("red");
    }

    @Test
    public void complexTest() {
        Complex complex = Complex.ComplexFactory("rookie", 21);

    }

    @Test
    public void testDuration() throws ParseException {
        Date date1 = new Date();
        date1 = DateUtils.addYears(date1, -1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date lastDate = DateUtils.parseDate("2018-12-11", "yyyy-MM-dd");
        Date date2 = new Date();
        System.out.println(dateFormat.format(date1));
        String day = DurationFormatUtils.formatPeriod(date1.getTime(), date2.getTime(), "d");
        System.out.println(day);
        System.out.println(DurationFormatUtils.formatPeriod(lastDate.getTime(), date2.getTime(), "M"));
    }

    @Test
    public void builder() {
        List<String> stringList = Lists.newArrayList("a", "b", "c");
//        StringBuilder builder = new StringBuilder();
//        for (int i=0;i<stringList.size();++i) {
//            builder.append(stringList.get(i));
//            if (i == stringList.size()-1) {
//                break;
//            }
//            builder.append(",");
//        }
//         String APPROVAL_TODO_SPLIT = "\n";
//
//        String a = "你有一条企业加入申请待处理! \\n申请人：张三";
//        System.out.println(a);
//        System.out.println(Arrays.toString(a.split(APPROVAL_TODO_SPLIT)));

//        String a = "access_token=111111111111111";
////        System.out.println(a.replace(a.split("=")[1],"222222"));
////
////        System.out.println(new Date(1538118315282L));
        int count = 0;
        Iterator<String> iterator = stringList.iterator();
        if (iterator.hasNext()) {
            count++;
            String element = iterator.next();
            if (element.equals("b")) {
                iterator.remove();
            }
        }
        final List<Integer> integerList = Lists.newArrayList(1, 23, 4, 5, 6);
        System.out.println(count);
        stringList.forEach(e -> {
//           for(int i=0;i<10;i++) {
//               e = e + i;
//           }
            for (Integer testInt : integerList) {
                e = e + testInt;
            }
        });

    }

    @Test
    public void Execute() {

//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        executorService.execute(() ->
//                System.out.println(111));


        String items = "[{\"appId\":\"de6aebf181b746b2862d43b3e303dbcd\",\"companyId\":\"500090d1828e43b394bfe621e4d5e47a\",\"createTime\":\"1576824320091\",\"region\":null,\"voipAccount\":\"135940584\",\"voipPwd\":\"47wO9463\"}]";
        List<ExtResponse> extResponses = JSONArray.parseArray(items, ExtResponse.class);
        System.out.println(extResponses.get(0).getAppId());
    }

    /**
     *
     * @throws InterruptedException
     */
    @Test
    public void complex() throws InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = Executors.newWorkStealingPool();
        IntStream.range(0, 12).mapToObj(n -> new Thread(() -> System.out.println(Thread.currentThread().getName())))
                .forEach(executorService::execute);
        executorService.awaitTermination(1, TimeUnit.SECONDS);

    }

    @Test
    public void parseJson() {
        String json = "{\"response\":{\"18538811510\":{\"detail\":{\"area\":[{\"city\":\"洛阳\"}],\"province\":\"河南\",\"type\":\"domestic\",\"operator\":\"联通\"},\"location\":\"河南洛阳联通\"}},\"responseHeader\":{\"status\":200,\"time\":1582270261199,\"version\":\"1.1.0\"}}";
        Map<String, Object> map = JSON.parseObject(json, Map.class);
        System.out.println(map.get("response").toString());
        map = JSON.parseObject(map.get("response").toString(), Map.class);
        System.out.println(map.get("18538811510"));
        map = JSON.parseObject(map.get("18538811510").toString(), Map.class);
        System.out.println(map.get("detail"));
        phoneBean phoneBean = JSON.parseObject(map.get("detail").toString(), phoneBean.class);
        System.out.println(phoneBean.getArea().get(0).get("city"));
        phoneBean = null;
        phoneBean = new phoneBean();
        phoneBean.setProvince("111");


    }

    @Data
    static class phoneBean {

        // 地区，市
        private List<Map<String,String>> area;

        /**
         * 省
         */
        private String province;

    }

    @Test
    public void testInt() {
        String message = "该号码触发您公司的号码黑名单，禁止呼叫！" + "\n如有疑问，请联系企业管理员";
        System.out.println(message);

    }

    @Test
    public void testSubString() {
        StringBuilder builder = new StringBuilder();
        String departmentName = "企业购买<font color=\"#fa9d04\">20200</font>通电销卫士检测，已消耗<font color=\"#fa9d04\">0</font>通";
        boolean breakFlag = false;
        for (int i=0;i<departmentName.length();i++) {
            char current = departmentName.charAt(i);
            if (('<' == current || breakFlag) && current != '>') {
                breakFlag = true;
                continue;
            }
            if ('>' == departmentName.charAt(i)) {
                breakFlag = false;
                continue;
            }
            builder.append(departmentName.charAt(i));
        }
        System.out.println(builder.length());

    }


    private String dealCallDurationFormat(int duration) {
        String durationFormat = "";
        if (0 == duration){
            return "--";
        }

        if (duration / 3600 > 0) {
            durationFormat = unitFormat(duration / 3600) + "小时";
        }
        if (duration / 60 % 60 > 0) {
            durationFormat += unitFormat(duration / 60 % 60) + "分";
        }
        if (duration % 60 > 0) {
            durationFormat += unitFormat(duration % 60) + "秒";
        }
        // 如果处理时间最后以0几秒开头，则去除数字0
        if (durationFormat.substring(0,1).equals("0")) {
            durationFormat = durationFormat.substring(1);
        }
        return durationFormat;
    }

    private static String unitFormat(int i) {
        String retStr;
        if (i >= 0 && i < 10)
            retStr = "0" + i;
        else
            retStr = "" + i;
        return retStr;
    }

    @Test
    public void testStringFormat() {
        String a = "adaddsds_ssfdadad_V2.1";

        System.out.println(a.substring(a.lastIndexOf("_")+1));
    }

    @Test
    public void copyListTest() {
        List<String> originList = new ArrayList<>();
        originList.add("a");
        originList.add("b");
        originList.add("c");

//        List<String> copyOneList = new ArrayList<>(originList);
//        Collections.copy(copyOneList,originList);
//        originList.remove(0);
        List<String> copyOneList = new ArrayList<>(originList);
        originList.remove(0);
        originList.add("d");
        System.out.println(JSON.toJSONString(originList));
        System.out.println(JSON.toJSONString(copyOneList));
    }

    @Test
    public void copyBeanListTest() {
        List<DateBean> originList = new ArrayList<>();
        originList.add(new DateBean("a"));
        originList.add(new DateBean("b"));
        originList.add(new DateBean("c"));

        List<DateBean> copyOneList = new ArrayList<>(originList);
        Collections.copy(copyOneList,originList);
//        originList.remove(0);
        //List<DateBean> copyOneList = (List<DateBean>) ((ArrayList<DateBean>) originList).clone();
        originList.get(0).setValue("d");
        System.out.println(JSON.toJSONString(originList));
        System.out.println(JSON.toJSONString(copyOneList));
    }

    @Test
    public void copyBeanConListTest() {
        DateBean origin = new DateBean();
        origin.setValue("a");

        DateBean copyDateBean = new DateBean(origin.getValue());
        origin.setValue("b");
        assert copyDateBean.getValue().equals(origin.getValue());
    }

    @Test
    public void testHour() {
        Map<String,Object> reqMap = new HashMap<>();
        long pid = 21143L;
        reqMap.put("pid",pid);
        int tableIndex = (int) Long.parseLong(reqMap.get("pid").toString()) % 16 ;
        System.out.println(tableIndex);
    }

    @Test
    public void testDivide() {
        System.out.println(durationMathConvert(35,6));
    }

    private int durationMathConvert(int totalDuration , int pickUpCount) {
        int convertDuration = totalDuration/pickUpCount;
        if (totalDuration%pickUpCount >= 5) {
            convertDuration += 1;
        }
        return convertDuration;
    }

    @Test
    public void testRemove() {
        ArrayList<Integer> integerArrayList = Lists.newArrayList(1, 2, 3);
        for (Integer integer : integerArrayList) {
            try {
                if (integer == 1) {
                    String a = null;
                    a.length();
                }
            } catch (NullPointerException ex) {
                ex.printStackTrace();
                continue;
            }
            System.out.println(integer);
        }
    }

    @Test
    public void splitTest() {
        String callId =  "*15000538768980_6b0c9776c1b04415965fa4a62b7a6b38*15000538760150005354545_7aa18d70e7b240eab92efb5849506994*15000538760_7fcbe34a1a4342a2a4950dcbde80c699*15000538760_78591493b5614982a31a3a36349b4298*15000538760_c89980b042dd4c85b9fdbf4d0e9fef2c";
        System.out.println(callId.length());
    }

    @Test
    public void streamDistinctTest() {
        List<String> integerArrayList = Lists.newArrayList("1", "2", "3");
        List<String> stringList = integerArrayList.subList(0, 2);
        System.out.println(stringList);
    }


}
