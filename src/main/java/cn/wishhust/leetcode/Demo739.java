package cn.wishhust.leetcode;
import java.util.Stack;

/**
 * 739. 每日温度
 *
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 *
 */

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
