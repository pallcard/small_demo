package cn.wishhust.leetcode;
public class Demo665 {


    public boolean checkPossibility(int[] nums) {

        if (nums.length <= 2) {
            return true;
        }

        int count = 1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                if (i == 0) {
                    nums[i] = Integer.MIN_VALUE;
                } else {
                    nums[i+1] = nums[i];
                }

                count--;
            }
            if (count < 0) {
                return false;
            }
        }

        return true;
    }



}
