package main.java.cn.wishhust.leetcode;

public class Demo153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // mid-1会丢掉要查找的值
                right = mid;
            }
        }
        return nums[left];
    }
}
