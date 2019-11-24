package cn.wishhust.leetcode;
import java.util.Arrays;
import java.util.Optional;

/**
 *
 * 238. 除自身以外数组的乘积
 *
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 */

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
