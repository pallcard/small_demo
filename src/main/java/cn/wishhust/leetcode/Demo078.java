package cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * dfs
 *
 */
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
