package cn.wishhust.leetcode;

/**
 *
 * 169. 多数元素
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 */

public class Demo169 {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int currentNum = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (currentNum == nums[i]) {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                currentNum = nums[i];
            }
        }
        return currentNum;
    }
}
