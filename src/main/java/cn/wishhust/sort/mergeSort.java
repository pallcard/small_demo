package main.java.cn.wishhust.sort;


/**
 *
 *
 */
public class mergeSort {
    public static void sort(int [] nums){

        sort(nums, 0, nums.length-1);

        // 打印数组
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    public static void sort(int [] nums, int low, int high) {
        int mid = low + (high - low) / 2;
        if (low < high) {
            sort(nums, low, mid);
            sort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }


    }

    public static void merge(int [] nums, int low, int mid, int high) {
        int [] temp = new int [high-low+1];
        int index = 0;
        int i = low;
        int j = mid+1;

        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                temp[index++] = nums[j++];
            }
        }

        while(i <= mid) {
            temp[index++] = nums[i++];
        }

        while (j <= high) {
            temp[index++] = nums[j++];
        }

        for (int k = 0; k < temp.length; k++) {
            nums[low++] = temp[k];
        }
    }

    public static void main(String[] args) {
        sort(new int [] {7, 6, 7, 11, 5, 12, 3, 0, 1});
    }

}
