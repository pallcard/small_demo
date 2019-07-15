package main.java.cn.wishhust.leetcode;

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
