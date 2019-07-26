package main.java.cn.wishhust.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Demo242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
        }

        for (int i = 0; i < t.length(); i++) {
            map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);
        }

        for (Character key: map1.keySet()) {
            // 这里需要使用equals方法
            if (!map2.containsKey(key) || !map2.get(key).equals(map1.get(key)) ) {
                return false;
            }
        }
        return true;
    }
    public boolean isAnagram2(String s, String t) {
        // 本题s，t中均为小写字母，故可以使用一个数组来存放字符出现次数
        int [] cnts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            cnts[t.charAt(i)-'a']--;
        }
        for (int i = 0; i < cnts.length; i++) {
            if (cnts[i] != 0) {
                return false;
            }
        }

        return true;
    }


}
