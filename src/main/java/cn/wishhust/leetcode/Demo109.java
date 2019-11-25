package cn.wishhust.leetcode;

/**
 *
 * 109. 有序链表转换二叉搜索树
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 */

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
