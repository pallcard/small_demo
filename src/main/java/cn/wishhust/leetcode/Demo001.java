package cn.wishhust.leetcode;

import java.util.HashMap;

/**
 * 1.两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 使用map存放数组中值和下标，判断map中是否含有taget-nums[i]的键。
 *
 */
public class Demo001 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexForNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexForNum.containsKey(target - nums[i])) {
                return new int[] {indexForNum.get(target-nums[i]),i};
            } else {
                indexForNum.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
