package main.java.cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Demo078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        subsets(nums, list, integers,0);
        return list;
    }

    public void subsets(int[] nums, List<List<Integer>> list, List<Integer> integers, int index) {

        list.add(new ArrayList<>(integers));
        if (integers.size() == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {

            integers.add(nums[i]);
            subsets(nums, list, integers,i+1);
            integers.remove(integers.size()-1);

        }
    }
}
