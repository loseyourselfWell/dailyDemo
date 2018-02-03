package day1124;


import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LearnFive {
    @Test
    public void LambdaTest(){
        List<String> stringList = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        Collections.sort(stringList, Comparator.reverseOrder());
        System.out.println(ArrayUtils.toString(stringList));
    }

    @Test
    public void PersonTest(){
        PersonFactory<Person> personFactory = Person::new;
        personFactory.create("yangzheng","mofei");
    }

    @Test
    public void StringNull(){
        String nullString = null;
        String str = "abc";
        StringBuilder builder = new StringBuilder(str);
        System.out.println(builder.append(nullString));
    }

    @Test
    public void buffer(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("QJY1218196800006,<br>");
        System.out.println(buffer.substring(0,buffer.length()-5));
    }
}
