package cn.wishhust.leetcode;
import java.util.Arrays;
import java.util.Stack;

public class Demo503 {

    public int[] nextGreaterElements(int[] nums) {

        int [] dist = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            j = j % nums.length;
            while (j != i && nums[j] <= nums[i]) {
                j++;
                j = j % nums.length;
            }
            if (nums[j] > nums[i]) {
                dist[i] = nums[j];
            } else {
                dist[i] = -1;
            }

        }
        return dist;

    }

    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int [] dist = new int[n];
        Arrays.fill(dist, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n*2; i++) {
            int num = nums[i%n];
            while (!stack.isEmpty() && nums[stack.peek()]< num) {
                dist[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return dist;

    }

}
