package main.java.cn.wishhust.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Demo225 {

    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public Demo225() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int preSize = queue.size();
        queue.add(x);

        for (int i = 0; i < preSize; i++) {
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
