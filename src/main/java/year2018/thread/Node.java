package year2018.thread;

import lombok.Data;

import java.util.*;

/**
 * @package year2018.thread
 * @Author: Administrator
 * @Date: 2018/7/12
 */
@Data
public class Node {

    private Node tail;

    private Node head;

    private Node next;

    private Node prev;

    private void test (Node node) {
        for (Node t = tail; t != null && t != node; t = t.prev) {
            System.out.println("node");
        }
    }

}
