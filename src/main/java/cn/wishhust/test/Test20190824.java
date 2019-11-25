package cn.wishhust.test;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test20190824 {

    public static boolean pattern(String pattern, String str) {
        final String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                map.get(pattern.charAt(i)).add(i);
            } else {
                List<Integer> integers = new ArrayList<>();
                integers.add(i);
                map.put(pattern.charAt(i), integers);
            }
        }
        for(Map.Entry<Character,List<Integer>> e: map.entrySet()) {
            List<Integer> value = e.getValue();
            int index = value.get(0);
            for (int i = 1; i < value.size(); i++) {
                if (!words[index].equals(words[value.get(i)])) {
                    return false;
                }
            }
        }
        return true;
    }

    public int x;
    public static void main(String[] args) {

//        System.out.println(pattern("aabb", "北京 北京 天津 天津"));
//        List<Integer> list =new ArrayList<>();
//        System.out.println(list.size());
//        String s1 = "";
//        String s2 = null;
//        String s3 = null;
//        System.out.println(x);
//        System.out.println(s1 == "");
//        System.out.println(s2.equals(s3));

        Integer a1 = 101;
        Integer b1 = 101;
        if (a1 == b1) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

        Integer a2 = -101;
        Integer b2 = -101;
        if (a2 == b2)  {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }
}
