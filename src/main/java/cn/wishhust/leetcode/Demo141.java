package cn.wishhust.leetcode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 *
 * 141. ��������
 *
 * ����һ�������ж��������Ƿ��л���
 *
 * Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л���
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺head = [3,2,0,-4], pos = 1
 * �����true
 * ���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
 *
 *
 * ʾ��?2��
 *
 * ���룺head = [1,2], pos = 0
 * �����true
 * ���ͣ���������һ��������β�����ӵ���һ���ڵ㡣
 *
 *
 * ʾ�� 3��
 *
 * ���룺head = [1], pos = -1
 * �����false
 * ���ͣ�������û�л���
 *
 *
 * ?
 *
 * ���ף�
 *
 * ������ O(1)�������������ڴ�����������
 *
 */
public class Demo141 {
    public boolean hasCycle(ListNode head) {
        ListNode p = head,q =head;
        if (p == null) {
            return false;
        }
        if (q.next == null) {
            return false;
        }
        q = q.next.next;
        while (p != null && q != null) {
            if (p == q) {
                return true;
            }else if(q.next != null && p.next != null) {
                q = q.next.next;
                p = p.next;
            } else {
                return false;
            }
        }
        return false;
    }

}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}
