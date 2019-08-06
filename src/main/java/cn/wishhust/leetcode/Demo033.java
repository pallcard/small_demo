package cn.wishhust.leetcode;

/**
 *
 * 旋转数组
 * 1. nums[mid] >= nums[left]
 *      1.1 left <= target && target <= mid   ==> 舍右
 *      1.2 其他 舍左
 *
 * 2. nums[mid] < nums[left]
 *      2.1 mid <= target && target <= right  ==> 舍左
 *      2.2 其他 舍右
 */

public class Demo033 {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[left]) {
                if (nums[mid] >= target && target >= nums[left]) {
                    right = mid;
                } else {
                    left = mid+1;
                }


            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid-1;
                }

            }
        }
        if (left == right && nums[left] == target) {
            return left;
        }
        return -1;
    }


    public static void main(String[] args) {
        search(new int[]{4,5,6,7,0,1,2}, 0);
    }

}
