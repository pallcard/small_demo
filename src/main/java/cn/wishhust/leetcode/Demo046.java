package cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Demo046 {
    public static List<List<Integer>> list = new ArrayList<>();
    /**
     *           1 2 3  --  1 2 3
     *                      1 3 2
     *
     * 1 2 3 --  2 1 3  --  2 1 3
     *                      2 3 1
     *
     *           3 2 1  --  3 2 1
     *                      3 1 2
     * @param nums
     * @return
     */

    public static List<List<Integer>> permute(int[] nums) {
        permuteK(nums, 0);
        return list;
    }


    // 交换法
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
    // 插入法 [1], [2,1] [1,2] ...
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

    // DFS
    // 1 2 3
    public static List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> string = new ArrayList<>();
        // visited数组
        boolean[] visited = new boolean[nums.length];
        permute3(nums,visited, list, string, 0);
        return list;
    }

    public static void permute3(int [] nums, boolean [] visited, List<List<Integer>> list, List<Integer> string, int k) {
        if (k == nums.length) {
            // Java中传递引用（地址）
            list.add(new ArrayList<>(string));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                string.add(nums[i]);
                visited[i] = true;
                permute3(nums, visited, list, string, k+1);
                string.remove(string.size()-1);
                visited[i] = false;
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[] {1,2,3}));
        System.out.println(permute2(new int[] {1,2,3}));
        final List<List<Integer>> lists = permute3(new int[]{1, 2, 3});
        System.out.println(lists.toString());
    }
}
