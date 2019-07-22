package main.java.cn.wishhust.leetcode;

public class Demo083 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode r = head;
        ListNode p = head.next;
        while (p != null) {
            if (r.val == p.val) {
                p = p.next;
            } else {
                r.next = p;
                r = r.next;
                p = p.next;
            }
        }
        return head;
    }
}
