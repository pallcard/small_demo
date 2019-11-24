package cn.wishhust.leetcode;

/**
 *
 * 322. 零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回?-1。
 *
 * 示例?1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 */


public class Demo326 {

    public static  boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        } if (n == 1) {
            return true;
        }
        while (n >= 3) {
            if (n / 3 == 1 && n % 3 ==0) {
                return true;
            } else if (n % 3 == 0) {
                n /= 3;
            } else {
                return false;
            }
        }
        return false;
//        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
//        return n > 0 && (1162261467 % n == 0);
    }


    public static void main(String[] args) {
        isPowerOfThree(19684);
    }
}
