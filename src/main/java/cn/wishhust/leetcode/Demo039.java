package cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 深度优先遍历，每一步都有candidates中情况可以走，若之和等于target，则放入集合中并return，若小于直接return
 */

public class Demo039 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        combinationSum(candidates,target,list,integers, 0);
        return list;
    }

    /**
     *
     * @param candidates
     * @param target
     * @param list
     * @param integers
     * @param index 为了去重
     */
    public static void combinationSum(int[] candidates, int target, List<List<Integer>> list, List<Integer> integers, int index) {
        if (target == 0) {
            list.add(new ArrayList<>(integers));
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                integers.add(candidates[i]);
                combinationSum(candidates, target-candidates[i], list, integers, i);
                integers.remove(integers.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int [] {2, 3, 6, 7}, 7));
    }

}
