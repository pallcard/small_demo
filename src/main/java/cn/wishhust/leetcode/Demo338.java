package cn.wishhust.leetcode;
public class Demo338 {

    public static int[] countBits(int num) {
        int [] dp = new int [num+1];

        if (num == 0) {
            return dp;
        }

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= num; i++) {
            double exp =  Math.floor(Math.log(i)/Math.log(2));
            int index = (int) (i-Math.pow(2, exp));
            dp[i] = dp[index]+1;
        }
        return dp;
    }

    public static void main(String[] args) {

        System.out.println(countBits(5));

    }
}
