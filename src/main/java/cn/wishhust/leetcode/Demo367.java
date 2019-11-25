package cn.wishhust.leetcode;

/**
 *
 * 367. 有效的完全平方数
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 *
 */

public class Demo367 {

    // 16 = 1 + 3 + 5 + 7
    // 25 = 1 + 3 + 5 + 7 + 9
    // 完全平方数 一定可以写成一个上述的和(等差数列)
    public boolean isPerfectSquare(int num) {
        int temp = 1;
        while (num > 0) {
            if (num - temp == 0) {
                return true;
            } else {
                num -= temp;
                temp += 2;
            }
        }
        return false;
    }
}
