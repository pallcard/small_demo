package cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        Arrays.sort(nums);
        boolean [] visited = new boolean[nums.length];
        subsetsWithDup(nums, list, integers,0, visited);
        return list;
    }

    public void subsetsWithDup(int[] nums, List<List<Integer>> list, List<Integer> integers, int index, boolean [] visited) {

        list.add(new ArrayList<>(integers));
        if (integers.size() == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i!=0 && nums[i] == nums[i-1] && !visited[i-1]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                integers.add(nums[i]);
                subsetsWithDup(nums, list, integers,i+1,visited);
                integers.remove(integers.size()-1);
                visited[i] = false;
            }
        }
    }
}
