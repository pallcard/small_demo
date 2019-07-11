package main.java.cn.wishhust.leetcode;

public class Demo {

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length-1;

        int mid = (left+right)/2;
        while (left < right) {
            if (nums[mid] == nums[mid-1]) {
                left = mid + 1;
            } else if(nums[mid] == nums[mid+1]) {
                right = mid - 1;
            } else {
                return nums[mid];
            }
            mid = (left + right) / 2;
        }

    }

}
