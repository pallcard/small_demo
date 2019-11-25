package cn.wishhust.leetcode;
import java.util.HashMap;
import java.util.Map;

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
