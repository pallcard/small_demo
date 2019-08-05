package cn.wishhust.leetcode;

public class Demo019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, q = head;
        while (n > 1) {
            p = p.next;
            n--;
        }
        if (p == null) {
            return head.next;
        }
        while (p!=null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;

        return head;
    }
}
