package cn.wishhust.leetcode;
import java.util.Arrays;
import java.util.Optional;

public class Demo238 {
    public int[] productExceptSelf(int[] nums) {
        // i 左边数乘积
        int [] left = new int [nums.length];
        // i 右边数乘积
        int [] right = new int [nums.length];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        for (int i = nums.length-2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            left[i] = left[i] * right[i];
        }
        return left;
    }
}
