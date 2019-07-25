package main.java.cn.wishhust.leetcode;

import java.util.HashSet;
import java.util.Set;

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
