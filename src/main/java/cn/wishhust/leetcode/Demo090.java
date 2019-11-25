package cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * dfs，加一个判断，类似于全排列 II
 * 当前元素与前一个元素相等，且前一个元素未被访问则跳过
 */
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
