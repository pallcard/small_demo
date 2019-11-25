package cn.wishhust.leetcode;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 242. 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 */
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
