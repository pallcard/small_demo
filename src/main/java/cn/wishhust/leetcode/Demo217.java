package cn.wishhust.leetcode;
import java.util.HashSet;
import java.util.Set;

public class Demo217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size() < nums.length;
    }
}
