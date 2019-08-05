package cn.wishhust.leetcode;

import java.util.HashMap;

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
