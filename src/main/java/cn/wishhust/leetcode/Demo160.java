package cn.wishhust.leetcode;
public class Demo160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode p = headA;
        ListNode q = headB;

        while (p != null) {
            lengthA++;
            p = p.next;
        }
        while (q != null) {
            lengthB++;
            q = q.next;
        }

        p = headA;
        q = headB;
        if (lengthA - lengthB > 0) {
            for (int i = 0; i < lengthA-lengthB; i++) {
                p = p.next;
            }
        } else {
            for (int i = 0; i < lengthB-lengthA; i++) {
                q = q.next;
            }
        }

        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
