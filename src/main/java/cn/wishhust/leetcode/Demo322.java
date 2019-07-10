package main.java.cn.wishhust.leetcode;

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
