package cn.wishhust.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Demo032 {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int [] integer = new int[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    integer[index++] = stack.pop();
                    integer[index++] = i;
                }
            }
        }
        Arrays.sort(integer,0, index);
        int max = 0;
        int current = 1;
        for (int i = 1; i < index; i++) {
            if (integer[i-1]+1 == integer[i]) {
                current +=1;
            } else {
                max = Math.max(max, current);
                current = 1;
            }
        }
        max = Math.max(max, current);
        return (max == 1) ? 0 : max;
    }

    public static void main(String[] args) {

        System.out.println(longestValidParentheses("()"));
    }
}
