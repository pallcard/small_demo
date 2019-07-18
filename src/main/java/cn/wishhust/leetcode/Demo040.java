package main.java.cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
