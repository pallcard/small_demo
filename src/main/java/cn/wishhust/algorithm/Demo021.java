package cn.wishhust.algorithm;

import java.util.Scanner;

/**
 * 完全背包问题
 * n件物品，和一个容量为W的背包，第i件物品的重量为w[i]，价值v[i],求解将哪些物品装入背包可使价值总和最大
 * 每种物品无数件，可以选择放或者不放
 *
 *
 * https://blog.csdn.net/lanyu_01/article/details/79815801
 *
 * f[i][v]=max{f[i-1][v-k*c[i]]+k*w[i]|0<=k<=n[i]}
 */

public class Demo021 {

    public static int manyPack(int V,int N,int[] weight,int[] value,int[] num){



        //初始化动态规划数组
        int[][] dp = new int[N+1][V+1];
        //为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
        for(int i=1;i<N+1;i++){
            for(int j=1;j<V+1;j++){
                //如果第i件物品的重量大于背包容量j,则不装入背包
                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if(weight[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else{
                    //考虑物品的件数限制
                    int maxV = Math.min(num[i-1],j/weight[i-1]);
                    for(int k=0;k<maxV+1;k++){
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-k*weight[i-1]]+k*value[i-1]);
                    }
                }
            }
        }
        /*//则容量为V的背包能够装入物品的最大值为
        int maxValue = dp[N][V];
        int j=V;
        String numStr="";
        for(int i=N;i>0;i--){
            //若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
            while(dp[i][j]>dp[i-1][j]){
                numStr = i+" "+numStr;
                j=j-weight[i-1];
            }
            if(j==0)
                break;
        }*/
        return dp[N][V];
    }



    public static void knapsack() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] w = new int[n+1];
        int [] v = new int[n+1];

        for (int i = 1; i <= n; i++) {
            w[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
        }

        int W = scanner.nextInt();

        int [][] dp = new int[n+1][W+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if(j<w[i]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    // 注意这里与01背包的区别
                    // 放入一个物品 i 时应当考虑还可能继续放入i，本次遍历与之前赋值有关。
                    // 01背包数 Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-w[i]]+v[i]);
                }
            }
        }

        // 根据数组反推 路径
        int j = W;
        int [] path = new int [n*n+1000];
        int index = 0;
        for (int i = n; i >=1 && j>0; i--) {
            // 若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
            while (dp[i][j] > dp[i-1][j]){
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
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] w = new int[n+1];
        int [] v = new int[n+1];

        for (int i = 1; i <= n; i++) {
            w[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
        }

        int W = scanner.nextInt();

        int [] dp = new int[W+1];

        for (int i = 1; i <= n; i++) {
            // 这里遍历顺序数从前往后遍历，这样i物品可以多次放入背包之中
            for (int j = w[i]; j <= W; j++) {
                if (j >= w[i]) {
                    dp[j] = Math.max(dp[j], dp[j-w[i]]+v[i]);
                }
            }
        }
        System.out.println(dp[W]);
    }

    public static void main(String[] args) {
        knapsack();
    }
}
