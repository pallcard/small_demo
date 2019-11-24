package cn.wishhust.leetcode;

/**
 *
 * 326. 3的幂
 *
 * 给定一个整数，写一个函数来判断它是否是 3?的幂次方。
 *
 * 示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 *
 */

public class Demo328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode list1 = head;
        if (head == null) {
            return head;
        }
        ListNode list2 = head.next, head2 = head.next;
        ListNode p = list2;
        int flag = 1;
        while (p != null) {
            p = p.next;
            if (flag == 1) {
                if (p == null) {
                    break;
                }
                flag = 0;
                list1.next = p;
                list1 = list1.next;
            } else {
                flag = 1;
                list2.next = p;
                list2 = list2.next;
            }

        }
        list1.next = head2;
        return head;

    }
}
