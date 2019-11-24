package cn.wishhust.leetcode;

/**
 *
 * 206. 反转链表
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 */

public class Demo206 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(0);
        if (head == null) {
            return head;
        }

        newHead.next = head;
        ListNode p = head.next, q = head.next;
        // 尾指针置空
        head.next = null;
        while (p != null) {
            p = p.next;
            q.next = newHead.next;
            newHead.next = q;
            q = p;
        }

        return newHead.next;
    }

    // 递归实现
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList2(next);
        newHead.next = head;
        head.next = null;

        return newHead;
    }
}
