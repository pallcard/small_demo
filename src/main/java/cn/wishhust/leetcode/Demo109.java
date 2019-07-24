package main.java.cn.wishhust.leetcode;

public class Demo109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode pre = findMid(head);
        ListNode mid = pre.next;
        pre.next = null;
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

    }


    private ListNode findMid(ListNode head) {
        if (null == head.next) {
            return head;
        }
        ListNode p = head, q = head.next;
        while (null != q.next && null != q.next.next) {
            p = p.next;
            q = q.next;
            q = q.next;
        }
        return p;
    }
}
