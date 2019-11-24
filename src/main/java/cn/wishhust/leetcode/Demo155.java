package cn.wishhust.leetcode;
import java.util.Stack;

/**
 * 155. ��Сջ
 *
 * ���һ��֧�� push��pop��top �����������ڳ���ʱ���ڼ�������СԪ�ص�ջ��
 *
 * push(x)?-- ��Ԫ�� x ����ջ�С�
 * pop()?-- ɾ��ջ����Ԫ�ء�
 * top()?-- ��ȡջ��Ԫ�ء�
 * getMin() -- ����ջ�е���СԪ�ء�
 * ʾ��:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> ���� -3.
 * minStack.pop();
 * minStack.top();      --> ���� 0.
 * minStack.getMin();   --> ���� -2.
 *
 */

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
