package main.java.cn.wishhust.sort;

/**
 *
 * 快速排序
 *
 * 时间复杂度 nlogn，不稳定
 */

public class QuickSort {

    public static void sort(int [] nums) {

        quickSort(nums,0,nums.length-1);

        // 打印数组
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }


    public static void quickSort(int [] nums, int l, int r) {
        if (l > r)
            return;
        int start = l;
        int end = r;
        int point = nums[start];

        l++;
        while (l < r) {
            while (nums[l] <= point) {
                l++;
            }
            while (nums[r] > point) {
                r--;
            }
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++; r--;
            }

        }
        nums[start] = nums[r];
        nums[r] = point;

        quickSort(nums,start,r-1);
        quickSort(nums,r+1,end);
    }

    public static void main(String[] args) {
        sort(new int [] {7, 6, 7, 11, 5, 12, 3, 0, 1});
    }

}
