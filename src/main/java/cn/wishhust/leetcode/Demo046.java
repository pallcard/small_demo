package main.java.cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Demo046 {
    public static List<List<Integer>> list = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        permuteK(nums, 0);
        return list;
    }

    public static void permuteK(int [] nums, int k) {
        if (k >= nums.length) {
            return;
        }
        if (k == nums.length-1) {
            List<Integer> numsList = new ArrayList<>();
            for (int num : nums) {
                numsList.add(num);
            }
            list.add(numsList);
            return;
        }
        for (int i = k; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
            permuteK(nums, k+1);
            nums[k] = nums[i];
            nums[i] = temp;
        }
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> numList = new ArrayList<>(nums.length);
        int index = 0;
        numList.add(nums[index++]);
        list.add(numList);
        while (list.size() > 0 && nums.length > list.get(0).size()) {
            List<Integer> top = list.remove(0);
            for (int j = top.size(); j >= 0; j--) {
                if(top.size() == j) {
                    top.add(nums[index]);
                } else {
                    top.add(j,nums[index]);
                }
                List<Integer> temp = new ArrayList<>(top);
                list.add(temp);
                top.remove(j);

            }
            if (list.get(0).size() > index) {
                index++;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[] {1,2,3}));
        System.out.println(permute2(new int[] {1,2,3}));
    }
}
