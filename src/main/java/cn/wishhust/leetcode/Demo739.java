package cn.wishhust.leetcode;
import java.util.Stack;

public class Demo739 {
    public int[] dailyTemperatures(int[] T) {
        int [] result = new int [T.length];
        result [T.length -1] = 0;
        for (int i = T.length-2; i >= 0 ; i--) {
            int j = i +1;
            while (j < T.length && T[i]>T[j]) {
                j++;
            }
            if (j==T.length) {
                result[i] = 0;
            } else {
                result[i] = j - i;
            }
        }
        return result;
    }

    public int[] dailyTemperatures2(int[] T) {
        int n = T.length;
        int [] dist = new int [n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i]>T[stack.peek()]) {
                int preIndex = stack.pop();
                dist[preIndex] = i - preIndex;
            }
            stack.add(i);
        }
        return dist;
    }

}
