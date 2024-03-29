package cn.wishhust.leetcode;

/**
 * 4. 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 */


public class Demo004 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        // 使得 m < n
        if (m > n) {
            int [] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            int temp1 = m;
            m = n;
            n = temp1;
        }
        // 对短的数组进行二分来确定i，j=(m+n+1)/2-i;
        int low = 0;
        int high = m;
        int mid = (m+n+1)/2;
        while (low <= high) {
            int i = low + (high-low)/2;
            int j = mid - i;

            if (i > low && nums1[i-1] > nums2[j]) {
                high = i - 1;
            } else if (i < high && nums2[j-1]>nums1[i]) {
                low = i + 1;
            } else {
                int maxLeft = 0;
                // num1 < num2
                if (i == 0) {
                    maxLeft = nums2[j-1];
                // num1 > num2
                } else if(j == 0) {
                    maxLeft = nums1[i-1];
                } else {
                    maxLeft = Math.max(nums1[i-1],nums2[j-1]);
                }

                if ((m+n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft+minRight) /2.0 ;
            }


        }
        return 0.0;

    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] {1,2}, new int[]{-1,3}));
    }

}
