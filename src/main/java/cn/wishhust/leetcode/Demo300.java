package cn.wishhust.leetcode;

/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 动态规划
 * LIS(n) = max(LIS(1), LIS(2), ... , LIS(n-1)) + (nums[n]>nums[i])?1:0;
 *
 */

public class Demo300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxLength = 1;

        int [] dp = new int [nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j] && dp[i]< dp[j]+1) {
                    dp[i] = dp[j]+1;
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }
        return maxLength;
    }
}
