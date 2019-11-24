package cn.wishhust.leetcode;

/**
 * 322. 零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 */


public class Demo322 {
    public static int coinChange(int[] coins, int amount) {

        int [] dp = new int[amount+1];

        // 将dp赋值为amount+1， amount+1为dp取不到的最大值
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount+1;
        }

//        for (int i = 1; i < coins.length; i++) {
//            for (int j = amount; j >= 0; j--) {
//                if (j >= coins[i]) {
//                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
//                }
//            }
//        }
//        return dp[amount];


        // 从1开始往后推
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];



    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5},11));
    }
}
