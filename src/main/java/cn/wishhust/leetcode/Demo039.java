package main.java.cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;

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
