package cn.wishhust.leetcode;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 指针的操作，画图分析
 */
public class Demo024 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode q = head.next;
        ListNode t;
        head = q;
        t = p;
        p = q.next;
        t.next = p;
        q.next = t;

        if (p != null) {
            q = p.next;
        }
        while (p != null && q != null) {

            t.next = q;
            t = p;
            p.next = q.next;
            q.next = p;
            p = t.next;
            if (p !=null) {
                q = p.next;
            }
        }
        return head;

    }
}
