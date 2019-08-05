package cn.wishhust.leetcode;

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
