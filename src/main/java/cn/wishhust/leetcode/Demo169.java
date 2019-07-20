package main.java.cn.wishhust.leetcode;

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
