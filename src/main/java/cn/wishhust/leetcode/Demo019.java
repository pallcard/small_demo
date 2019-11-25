package cn.wishhust.leetcode;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 两个指针，让一个指针先走n步，然后两个指针一起走，直到先走的指针指向null
 */
public class Demo019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, q = head;
        while (n > 1) {
            p = p.next;
            n--;
        }
        if (p == null) {
            return head.next;
        }
        while (p!=null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;

        return head;
    }
}
