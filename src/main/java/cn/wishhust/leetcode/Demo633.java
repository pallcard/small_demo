package cn.wishhust.leetcode;


/**
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 *
 * 示例1:
 *
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *  
 *
 * 示例2:
 *
 * 输入: 3
 * 输出: False
 *
 *
 */

public class Demo633 {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);
        while (i < j && i*i+j*j != c) {
            if (i*i+j*j < c) {
                i++;
            } else {
                j--;
            }
        }
        if (i*i+j*j == c) {
            return true;
        }
        return false;
    }
}
