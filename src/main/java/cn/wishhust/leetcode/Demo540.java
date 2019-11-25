package cn.wishhust.leetcode;
/**
 *
 * 注意点
 *
 * 1 2 2 3 3 4 4
 * l = 0, r = 6, m = 3
 * 中间值与右边相等，有效区间在左边
 *
 * 1 1 2 3 3 4 4 8 8
 * l = 0, r = 8, m = 4
 * 中间值与左边相等，有效区间在左边
 *
 * 要保证 l,r,m 均为偶数，
 *
 */

public class Demo540 {


    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length-1;


        while (left < right) {
            int mid = (left+right)/2;
            if (mid % 2 != 0) {
                mid--;
            }
            if(nums[mid] == nums[mid+1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }

        return nums[left];

    }

    public static void main(String[] args) {
        singleNonDuplicate(new int[]{1,1,2,3,3});
    }
}
