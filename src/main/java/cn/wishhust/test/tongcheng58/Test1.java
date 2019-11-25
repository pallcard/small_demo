package cn.wishhust.test.tongcheng58;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String[] split = str.split(",");
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        System.out.println(list.size());
    }
}
