package cn.wishhust.leetcode;

/**
 * 83. 删除排序链表中的重复元素
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 */
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
