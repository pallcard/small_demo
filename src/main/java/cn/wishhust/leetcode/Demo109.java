package cn.wishhust.leetcode;

public class Demo109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode pre = findMid(head);
        // 判断是否只剩一个结点
        if (null != pre.next) {
            ListNode mid = pre.next;
            pre.next = null;
            TreeNode root = new TreeNode(mid.val);
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(mid.next);
            return root;
        // 只剩下一个结点的情况
        } else {
            return new TreeNode(pre.val);
        }



    }

    // 找链表中间点的前一个
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
