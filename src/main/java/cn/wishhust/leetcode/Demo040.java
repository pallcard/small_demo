package cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 深度优先遍历，但是需要一个visited数组保存之前使用过的数字。
 *
 */
public class Demo040 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        Arrays.sort(candidates);
        boolean [] visited = new boolean[candidates.length];
        combinationSum2(candidates,target,list,integers, visited, 0);
        return list;
    }

    public static void combinationSum2(int[] candidates, int target, List<List<Integer>> list, List<Integer> integers, boolean [] visited, int index) {
        if (target == 0) {
            list.add(new ArrayList<>(integers));
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i != 0 && candidates[i] == candidates[i-1] && !visited[i-1]) {
                continue;
            }

            if (target >= candidates[i] && !visited[i]) {
                visited[i] = true;
                integers.add(candidates[i]);
                combinationSum2(candidates, target-candidates[i], list, integers, visited, i);
                integers.remove(integers.size()-1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int [] {10,1,2,7,6,1,5}, 8));
    }
}
