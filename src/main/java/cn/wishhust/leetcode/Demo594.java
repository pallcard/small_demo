package cn.wishhust.leetcode;
import java.util.HashMap;
import java.util.Map;

/**
 * 594. 最长和谐子序列
 *
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 *
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 * 说明: 输入的数组长度最大不超过20,000.
 *
 */

public class Demo594 {
    public static int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int longest = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key+1)) {
                longest = Math.max(longest, map.get(key)+map.get(key+1));
            }
//            if (map.containsKey(key-1)) {
//                longest = Math.max(longest, map.get(key)+map.get(key-1));
//            }

        }
//        System.out.println(map.keySet().toString());
        return longest;

    }


    public static void main(String[] args) {
        findLHS(new int[]{1,3,2,2,5,2,3,7});
    }
}
