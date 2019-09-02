package cn.wishhust.test.shunfeng;


import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static int longdp(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println(longdp(arr));

    }
}
