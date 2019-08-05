package cn.wishhust.leetcode;
import java.util.Stack;

public class Demo155 {

    Stack<Integer> dataStack;
    Stack<Integer> minStack;
    int min;

    /** initialize your data structure here. */
    public Demo155() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        dataStack.push(x);
        min = Math.min(min, x);
        minStack.push(min);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return min;
    }
}
