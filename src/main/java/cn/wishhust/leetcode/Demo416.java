package cn.wishhust.leetcode;
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
