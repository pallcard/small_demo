package cn.wishhust.leetcode;
/**
 * 540. 有序数组中的单一元素
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 *
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
