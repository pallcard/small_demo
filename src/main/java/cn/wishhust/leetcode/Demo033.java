package cn.wishhust.leetcode;

/**
 * 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 通过比较数组的中间值和最左值比较大小，来判断数组中有序的一段，例如若nums[left] <= nums[mid], 则说明left -- mid 有序，反之，mid -- right有序；
 * 判断target是否在有序的这一段中，若在，则舍弃另一半；否则舍弃该段。
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
