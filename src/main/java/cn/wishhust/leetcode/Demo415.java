package cn.wishhust.leetcode;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 */

public class Demo415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int d = 0;
        while (i>=0 || j>=0) {
            int t;
            if (i>=0 && j >= 0) {
                t = d + (num1.charAt(i)-'0')+(num2.charAt(j)-'0');
            } else if (i>=0) {
                t = d + (num1.charAt(i)-'0');
            } else {
                t = d + (num2.charAt(j)-'0');
            }
            d = t / 10;
            sb.append(t % 10);
            i--;j--;
        }
        if (d > 0) {
            sb.append(d);
        }
        return sb.reverse().toString();
    }

}
