package cn.wishhust.leetcode;
import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 *
 */

public class Demo131 {
    public static List<List<String>> partition(String s) {

        List<List<String>> list = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        partition(s, list, strings);

        return list;

    }

    public static void partition(String s, List<List<String>> list, List<String> strings) {
        if (s.length() <= 0) {
            return;
        }

        if (isPalindromic(s)) {
            strings.add(s);
            list.add(new ArrayList<>(strings));
            strings.remove(strings.size()-1);
        }


        for (int i = 1; i <= s.length(); i++) {

            String part = s.substring(0,i);
            if (isPalindromic(part)) {
                strings.add(part);
                partition(s.substring(i), list, strings);
                strings.remove(strings.size()-1);
            }

        }
    }


    // aba   aabbaa
    public static boolean isPalindromic(String str) {
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-i-1)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(partition("bb"));
    }
}
// [,,["c","b","bb","c","c"],["c","b","bb","cc"],["c","bb","b","c","c"],["c","bb","b","cc"],["c","bbb","c","c"],["c","bbb","cc"],]
