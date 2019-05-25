package year2019;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @packageName: year2019
 * @Auther: likun
 * @Date: 2019/5/25 19:36
 * @Description:
 */
public class TestDemo {

    @Test
    public static void mapTest(Map<String,Object> reqMap) {


    }

    public static void main(String[] args) {
        Map<String,Object> hashMap = new ConcurrentHashMap<>();
        mapTest(hashMap);
        Collection<Integer> collection = new ArrayList<>();
        //collection.add(1);
        Optional<Integer> optional = max(collection);
        if (optional.isPresent()) {
            System.out.println("present");
        } else {
            System.out.println("not present");
        }
    }

    public static <E extends Comparable<E>> Optional<E> max(Collection<E> collection) {
        if (collection.isEmpty()) {
            return Optional.empty();
        }
        return null;
    }
}
