package main.java.cn.wishhust.leetcode;

public class Demo021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode head, r;
        if (p == null) {
            return q;
        } else if (q == null) {
            return p;
        }
        if (p.val <= q.val) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }
        r = head;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                r.next = p;
                r = r.next;
                p = p.next;
            } else {
                r.next = q;
                r = r.next;
                q = q.next;
            }
        }

        if (p != null) {
            r.next = p;
        } else if (q != null) {
            r.next = q;
        }

        return head;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

}
