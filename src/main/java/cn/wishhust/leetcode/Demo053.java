package cn.wishhust.leetcode;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 *
 * 动态规划
 * 连续子数组 dp[i] = max( dp[i] , (dp[i-1]+dp[i]))
 * 当前最大和，要么包含当前元素，要么不含当前元素，(在原数组上更新)。
 */

public class Demo053 {

    public static int maxSubArray(int[] nums) {
//        int [] dp = new int[nums.length];
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        dp[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = Math.min(Math.min(dp[i-1],dp[i-1]+nums[i]),nums[i]);
//        }
//        return dp[nums.length-1];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 保留前面累加和与以当前元素为开始
            nums[i] = Math.max(nums[i], nums[i-1]+nums[i]);
            sum = Math.max(sum, nums[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
