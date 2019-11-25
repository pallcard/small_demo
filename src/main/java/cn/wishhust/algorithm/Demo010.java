package cn.wishhust.algorithm;

import java.util.Arrays;

/**
 *
 *  变态跳青蛙
 *  青蛙可以跳1，2，3，，，n阶。
 *  问跳到n有多少种不同方法。
 *
 *  f(n) = f(n-1) + f(n-2) + ,,, + f(0)
 *  f(n-1) = f(n-2) + f(n-3) + ,,, + f(0)
 *  f(n) = 2 * f(n-1)
 *
 */
public class Demo010 {

    public static void main(String[] args) {
        System.out.println(jumpFloor(3));
        System.out.println(jumpFloor2(3));
    }


//    f(0) = 1
//    f(1) = 1
//    f(2) = 2
//    f(3) = 4
    public static int jumpFloor(int target) {
        int [] dp = new int[target];
        Arrays.fill(dp,1);  // 数组所有元素置1（相当于所有元素+f(0)）
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target-1];
    }



    public static int jumpFloor2(int target) {
        return (int) Math.pow(2, target-1);
    }
}
