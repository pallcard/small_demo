package main.java.cn.wishhust.algorithm.dp;

public class CardGame1 {
    public static int cardGame(int[] A, int n) {

        // f[i][j]表示在牌[i...j]下，先选能获得的最大分数
        // s[i][j]表示在牌[i...j]下，后选能获得的最大分数
        int[][] f = new int[n][n];
        int[][] s = new int[n][n];
        for (int j = 0; j < n; j++) {
            f[j][j] = A[j];   //i==j,先拿的人只有一种选择，就是arr[i]
            s[j][j] = 0;      //i==j,后拿的人没有纸牌可拿
            //计算的方向是每一列从下往上,先计算行，后计算列
            for (int i = j - 1; i >= 0; i--) {
                // 先拿的人有两种选择，如果拿arr[i]，那么对于arr[i+1]到arr[j]就成了后拿；
                // 如果拿arr[j]那么对于arr[i]到arr[j-1]就成了后拿，选择最优的。
                f[i][j] = Math.max(A[i] + s[i + 1][j], A[j] + s[i][j - 1]);
                // 在A拿完之后，B成了先拿的人，但是A会给B剩下一种最差的方案，
                // 也就是在f[i+1][j]和f[i][j-1]中选择最小的一个
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]); // 后手只能获得较小的分数
            }
        }
        return Math.max(f[0][n - 1], s[0][n - 1]);


    }
}
