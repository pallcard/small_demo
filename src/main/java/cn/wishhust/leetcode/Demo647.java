package cn.wishhust.leetcode;

/**
 * 647. 回文子串
 *
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 *
 * 输入的字符串长度不会超过1000。
 *
 */

public class Demo647 {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length()+1; j++) {
                if (isPalinrome(s.substring(i,j))){
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isPalinrome(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }


    // 中心向两端扩张
    static int cnt = 0;
    public static int countSubstrings2(String s) {


        for (int i = 0; i < s.length(); i++) {
            // 子串为奇数个字符
            extendSubstrings(s,i,i);
            // 子串为偶数个字符
            extendSubstrings(s,i,i+1);
        }
        return cnt;
    }

    private static void extendSubstrings(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            cnt++;
        }
    }

    public static void main(String[] args) {
        countSubstrings2("aaa");
    }
}
