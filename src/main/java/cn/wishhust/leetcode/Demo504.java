package cn.wishhust.leetcode;

/**
 * 504. 七进制数
 *
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 *
 * 示例 1:
 *
 * 输入: 100
 * 输出: "202"
 * 示例 2:
 *
 * 输入: -7
 * 输出: "-10"
 * 注意: 输入范围是 [-1e7, 1e7] 。
 *
 *
 */
public class Demo504 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        String symbol = "";
        if (num < 0) {
            symbol = "-";
            num = 0 - num;
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int n = num % 7;
            num = num / 7;
            sb.append(n);
        }
        return symbol + sb.reverse().toString();

    }
}
