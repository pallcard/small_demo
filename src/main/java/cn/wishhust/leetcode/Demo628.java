package cn.wishhust.leetcode;

/**
 * 628. 三个数的最大乘积
 *
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 *
 */

public class Demo628 {
    public int maximumProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max3 = max2;
                max2 = max;
                max = nums[i];
            } else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            }

            if (nums[i] < min) {
                min2 = min;
                min = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }
        if (min < 0 && min2 < 0 && min*min2 > max2*max3) {
            return min*min2*max;
        } else {
            return max*max2*max3;
        }

    }
}
