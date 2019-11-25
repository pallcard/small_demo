package cn.wishhust.leetcode;

/**
 * 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 两个指针分别指向两个链表，比较大小后，将小的连到新链表上。
 *
 */

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
