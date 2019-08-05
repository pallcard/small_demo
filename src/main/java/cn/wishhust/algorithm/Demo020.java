package cn.wishhust.algorithm;

import java.util.Scanner;

/**
 * 01背包问题
 * n件物品，和一个容量为W的背包，第i件物品的重量为w[i]，价值v[i],求解将哪些物品装入背包可使价值总和最大
 * 每种物品只有一件，可以选择放或者不放
 *
 */

public class Demo020 {

    // https://www.cnblogs.com/William-xh/p/7305877.html
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

        // 根据数组反推 路径
        int j = W;
        int [] path = new int [n];
        int index = 0;
        for (int i = n; i >=1 && j>0; i--) {
            if (dp[i][j] == dp[i-1][j-w[i]]+v[i]) {
                path[index++] = i;
                j -= w[i];
            }
        }

        System.out.println(dp[n][W]);
        for (int i = 0; i < index; i++) {
            System.out.print(path[i]+" ");
        }
        System.out.println();
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

        // 若必须装满
//        for (int i = 1; i <= W; i++) {
//            dp[i] = Integer.MIN_VALUE;
//        }

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
//        5
//        2 6
//        2 3
//        6 5
//        5 4
//        4 6
//        10
        knapsack();
//        knapsack2();
    }
}
