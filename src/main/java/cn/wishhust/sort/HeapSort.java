package main.java.cn.wishhust.sort;

import sun.security.util.Length;

/**
 * 堆排序
 *
 * 时间复杂度 nlogn，不稳定
 *
 * 思想：
 * 将数组构造成大根堆，交换第一个元素与最后一个元素，调整为大根堆，交换元素，调整。。。
 *
 * 数组长度n，第一个非叶子结点 2*n-1，
 *
 *
 */

public class HeapSort {

    public static void sort(int [] nums) {

        // 调整为大根堆
        for (int i = nums.length/2-1; i >= 0; i--) {
            adjust(nums, i, nums.length);
        }

        // 替换最后一个元素
        for (int i = nums.length-1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            adjust(nums, 0, i);
        }

        // 打印数组
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    /**
     * 调整数组
     * @param nums    待排序数组
     * @param i       待调整的数下标
     * @param length  数组有效长度
     */

    public static void adjust(int [] nums, int i, int length) {
        int temp = nums[i];
        for (int j = 2*i+1; j < length; j = j*2+1) {
            if (j+1< length && nums[j+1] > nums[j]) {
                j++;
            }
            if (nums[j] > temp) {
                nums[i] = nums[j];
                i = j;
            } else {
                break;
            }
        }
        nums[i] = temp;
    }

    public static void main(String[] args) {
        sort(new int [] {7, 6, 7, 11, 5, 12, 3, 0, 1});
    }
}
