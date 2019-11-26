package cn.wishhust.leetcode;

/**
 * 680. 验证回文字符串 Ⅱ
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 *
 */

public class Demo680 {
    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        int tolerant = 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else if (tolerant > 0) {
                tolerant--;
                if (i+1<s.length() && s.charAt(i+1) == s.charAt(j) && j-1>=0 && s.charAt(j-1) == s.charAt(i)) {
                    // cupucu
                    if (i+2<s.length() && j-1>=0  && s.charAt(i+2)== s.charAt(j-1)) {
                        i++;
                    } else {
                        j--;
                    }

                } else if(i+1<s.length() && s.charAt(i+1) == s.charAt(j)) {
                    i++;
                } else {
                    j--;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean validPalindrome2(String s) {
        int i = 0;
        int j = s.length()-1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return validPalindrome3(s.substring(i,j)) || validPalindrome3(s.substring(i+1,j+1));
            }
        }
        return true;
    }

    public static boolean validPalindrome3(String s) {
        int i = 0;
        int j = s.length()-1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("aeacdeaeaaaaaaeaedcae"));
        System.out.println(validPalindrome2("aeacdeaeaaaaaaeaedcae"));
    }
}
