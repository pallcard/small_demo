package cn.wishhust.leetcode;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 *
 */

public class Demo128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int longest = 0;
        for (int num : set) {
            // 使得num为set中最小的数
            if (!set.contains(num-1)) {

                int current = 1;

                while (set.contains(num+1)) {
                    current += 1;
                    num++;
                }
                longest = Math.max(longest,current);
            }
        }
        return longest;

    }

}
