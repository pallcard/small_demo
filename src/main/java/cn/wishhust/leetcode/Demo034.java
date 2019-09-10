package cn.wishhust.leetcode;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 二分查找，找到目标值后，向左向右搜索。
 *
 */

public class Demo034 {
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length-1;
        while (left<right) {
            int mid = left + (right-left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] != target) {
            return new int[]{-1, -1};
        }

        int temp = left;
        int temp2 = left;

        while (temp-1>=0 && nums[temp-1] == target) {
            temp--;
        }

        while (temp2+1<nums.length && nums[temp2+1] == target) {
            temp2++;
        }

        return new int[]{temp, temp2};
    }

    public static void main(String[] args) {
        searchRange(new int[]{5,7,7,8,8,10},8);
    }
}
