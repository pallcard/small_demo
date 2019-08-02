package main.java.cn.wishhust.design.mode.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        Aggregate aggregate = new ConcretrAggregate();
        Iterator<Integer> iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }



        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        java.util.Iterator<Integer> iterator2 = integers.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}
