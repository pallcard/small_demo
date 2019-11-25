package cn.wishhust.test.dianxing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Test2 {
    public static String intToRoman(int num) {
        Map<String, Integer> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();

        map.put("M",1000);
        map.put("CM",900);
        map.put("D",500);
        map.put("CD",400);
        map.put("C",100);
        map.put("XC",90);
        map.put("L",50);
        map.put("XL",40);
        map.put("X",10);
        map.put("IX",9);
        map.put("V",5);
        map.put("IV",4);
        map.put("I",1);

        for(Map.Entry<String, Integer> e : map.entrySet()) {
            int count = num / e.getValue();
            num = num % e.getValue();
            while (count-- > 0) {
                sb.append(e.getKey());

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        System.out.println( intToRoman(n));
    }
}
