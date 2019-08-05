package cn.wishhust.leetcode;

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
