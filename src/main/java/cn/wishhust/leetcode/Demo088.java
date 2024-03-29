package cn.wishhust.leetcode;

/**
 * 88. 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 双指针法，两个指向初始值m-1, n-1；
 * 比较大小，将较大的从nums1的末尾开始放
 *
 */
public class Demo088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] temp = new int [m];
        for (int i = 0; i < m; i++) {
            temp[i] = nums1[i];
        }
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (temp[i] <= nums2[j]) {
                nums1[k++] = temp[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }
        while (i < m) {
            nums1[k++] = temp[i++];
        }
        while (j < n) {
            nums1[k++] = nums2[j++];
        }
    }
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;

        while (m > 0 && n > 0) {
            if (nums1[m-1] < nums2[n-1]) {
                nums1[index--] = nums2[n-1];
                n--;
            } else {
                nums1[index--] = nums1[m-1];
                m--;
            }
        }
        while (n>0) {
            nums1[index--] = nums2[n-1];
            n--;
        }
    }
}
