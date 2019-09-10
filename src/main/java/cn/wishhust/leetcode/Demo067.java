package cn.wishhust.leetcode;

/**
 * 67. 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 */
public class Demo067 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int d = 0;
        while (i>=0 || j>=0) {
            int t;
            if (i>=0 && j >= 0) {
                t = d + (a.charAt(i)-'0')+(b.charAt(j)-'0');
            } else if (i>=0) {
                t = d + (a.charAt(i)-'0');
            } else {
                t = d + (b.charAt(j)-'0');
            }
            d = t / 2;
            sb.append(t % 2);
            i--;j--;
        }
        if (d == 1) {
            sb.append(d);
        }
        return sb.reverse().toString();
    }
}
