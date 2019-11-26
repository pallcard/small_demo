package cn.wishhust.leetcode;

/**
 * 416. 分割等和子集
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 */

public class Demo416 {

    public static boolean canPartition(int[] nums) {

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0 || nums.length == 1) {
            return false;
        }

        int C = sum / 2;

        boolean [] dp = new boolean[C+1];

        // 先写第 1 行，看看第 1 个数是不是能够刚好填满容量为 C
        // 先填第一个数 nums[0]
        for (int j = 1; j < C + 1; j++) {
            if (nums[0] == j) {
                dp[j] = true;
                // 如果等于，后面就不用做判断了，因为 j 会越来越大，肯定不等于 nums[0]
                break;
            }
        }

        // 01背包问题
        for (int i = 1; i < nums.length; i++) {
            for (int j = C; j >= 0 && j >= nums[i]; j--) {
                dp[j] = dp[j-nums[i]] || dp[j];
                // dp[C]为true，直接返回
                if (dp[C]) {
                    return true;
                }
            }
        }

        return dp[C];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
    }
}
