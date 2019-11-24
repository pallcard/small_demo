package cn.wishhust.leetcode;
import java.util.Stack;

/**
 * 230. �����������е�KС��Ԫ��
 *
 * ����һ����������������дһ������?kthSmallest?���������е�?k?����С��Ԫ�ء�
 *
 * ˵����
 * ����Լ��� k ������Ч�ģ�1 �� k �� ����������Ԫ�ظ�����
 *
 * ʾ�� 1:
 *
 * ����: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 * ?  2
 * ���: 1
 * ʾ�� 2:
 *
 * ����: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * ���: 3
 * ���ף�
 * ��������������������޸ģ�����/ɾ����������������ҪƵ���ز��ҵ� k С��ֵ���㽫����Ż�?kthSmallest?������
 *
 */
public class Demo232 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public Demo232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
