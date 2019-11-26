package cn.wishhust.leetcode;

/**
 * 696. 计数二进制子串
 *
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 *
 * 重复出现的子串要计算它们出现的次数。
 *
 * 示例 1 :
 *
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 *
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 *
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * 示例 2 :
 *
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 * 注意：
 *
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 *
 *
 */


public class Demo696 {
    public int countBinarySubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length()+1; j++) {
                if (isEqual01(s.substring(i,j))) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isEqual01(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count++;
            } else {
                count--;
            }
        }
        for (int i = 1; i < s.length()/2; i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                return false;
            }
        }
        return count==0;
    }

    public int countBinarySubstrings2(String s) {
        // pre 前一个数字连续出现的次数，cur 当前数字连续出现的次数，count 结果子串个数
        int pre = 0, cur = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }
//            前一个数字出现的次数 >= 后一个数字出现的次数，则一定包含满足条件的子串
            if (pre >= cur) {
                count++;
            }

        }
        return count;
    }

}
