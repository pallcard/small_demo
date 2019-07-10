package main.java.cn.wishhust.leetcode;

public class Demo198 {
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return nums[n-1];
        }

        nums[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            nums[i] = Math.max(nums[i]+nums[i-2],nums[i-1]);
        }
        return nums[n-1];
    }

    public static void main(String[] args) {
        int [] nums = new int [] {2,1,1,2};
        System.out.println(rob(nums));
    }
}
