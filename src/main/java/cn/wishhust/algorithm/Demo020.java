package main.java.cn.wishhust.algorithm;

import java.util.Scanner;

/**
 * 01背包问题
 *
 */

public class Demo020 {

    //https://www.cnblogs.com/William-xh/p/7305877.html
    public static void knapsack() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int w[] = new int[n+1];
        int v[] = new int[n+1];
        for (int i = 1; i <= n; i++) {
            w[i] = in.nextInt();
            v[i] = in.nextInt();
        }

        int W = in.nextInt();

        // 前i件物品中选择若干件放在承重为j的背包中, 可以取得的最大价值
        int dp[][] = new int[n+1][W+1];

        for (int i = 1; i <= n; i++) {
            for (int j = W; j > 0; j--) {
                // 放不下第i个物品
                if(j < w[i])
                    dp[i][j] = dp[i-1][j];
                else
                    // 能放下第i个物品
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
            }
        }
        System.out.println(dp[n][W]);
    }

    public static void knapsack2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int w[] = new int[n+1];
        int v[] = new int[n+1];
        for (int i = 1; i <= n; i++) {
            w[i] = in.nextInt();
            v[i] = in.nextInt();
        }
        int W = in.nextInt();

        int dp [] = new int [W+1];

        for (int i = 1; i <= n; i++) {
            for (int j = W; j > 0; j--) {
                if(j >= w[i]) {
                    dp[j] = Math.max(dp[j],dp[j-w[i]]+v[i]);
                }
            }
        }
        System.out.println(dp[W]);
    }

    public static void main(String[] args) {
        knapsack();
        knapsack2();
    }
}
