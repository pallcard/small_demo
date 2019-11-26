package cn.wishhust.leetcode;
import java.util.ArrayList;
import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 *
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * 示例 1:
 *
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * 输出:
 * "apple"
 * 示例 2:
 *
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 *
 * 输出:
 * "a"
 * 说明:
 *
 * 所有输入的字符串只包含小写字母。
 * 字典的大小不会超过 1000。
 * 所有输入的字符串长度不会超过 1000。
 *
 *
 */


public class Demo524 {
    public static String findLongestWord(String s, List<String> d) {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < d.size(); i++) {
            int length = d.get(i).length();
            if (isSubString(s, d.get(i)) && length > max) {
                max = length;
                maxIndex = i;
            } else if (isSubString(s, d.get(i)) && length == max) {
                if (d.get(i).compareTo(d.get(maxIndex))<0) {
                    maxIndex = i;
                }
            }
        }
        if (max == 0) {
            return "";
        } else {
            return d.get(maxIndex);
        }
    }

    public static boolean isSubString(String s, String sub) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < sub.length()) {
            if (s.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (j == sub.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        final ArrayList<String> strings = new ArrayList<>();
        strings.add("ba");
        strings.add("ab");
        strings.add("b");

        System.out.println(findLongestWord("bab",strings));
    }
}
