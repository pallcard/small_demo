package cn.wishhust.leetcode;
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
