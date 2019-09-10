package cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * DFS, 当前元素与前一个元素相等，且前一个元素未被访问则跳过
 */
public class Demo047 {

    // DFS
    // 1 2 3
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> string = new ArrayList<>();
        // 对数组进行排序
        Arrays.sort(nums);
        // visited数组
        boolean[] visited = new boolean[nums.length];
        permuteUnique(nums, visited, list, string, 0);
        return list;
    }

    public static void permuteUnique(int [] nums, boolean [] visited, List<List<Integer>> list, List<Integer> string, int k) {
        if (k == nums.length) {
            // Java中传递引用（地址）
            list.add(new ArrayList<>(string));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 当前元素与前一个元素相等，且前一个元素未被访问则跳过
            // i!=0  =>当前元素不为第一个 => 当前元素有前一个元素
            if (i !=0 && nums[i] == nums[i-1] && !visited[i-1]) {
                continue;
            }
            if (!visited[i]) {
                string.add(nums[i]);
                visited[i] = true;
                permuteUnique(nums, visited, list, string, k+1);
                string.remove(string.size()-1);
                visited[i] = false;
            }

        }
    }

    public static void main(String[] args) {
        final List<List<Integer>> lists = permuteUnique(new int[]{3,3,0,3});
        System.out.println(lists.toString());
    }
}
