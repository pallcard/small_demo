package main.java.cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Demo448 {
    // 方法一：利用下标，将数组中元素对应的下标的元素置负数，看最终数组中不为负数的下标即为所求
    // 方法二：利用下标，使其与对应的位置交换
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            if (nums[Math.abs(nums[i])-1]> 0) {
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0) {
                list.add(i+1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int [] {4,3,2,7,8,2,3,1} ));
    }
}
