package cn.wishhust.leetcode;
import java.util.ArrayList;
import java.util.List;

public class Demo234 {
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;

        List<Integer> list = new ArrayList<>();


        while (p != null) {
            list.add(p.val);
            p = p.next;
        }

        for (int i = 0; i < list.size()/2; i++) {
            if (!list.get(i).equals(list.get(list.size()-i-1))) {
                return false;
            }
        }

        return true;
    }

    // 快慢指针来确定中间值
    public static boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head, fast = head.next;
        ListNode pre = null, prepre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        ListNode p = slow.next;
        slow.next = pre;

        if (fast == null) {
            while (slow.next != null) {
                slow = slow.next;
                if (slow.val != p.val) {
                    return false;
                }
                p = p.next;
            }
        } else if (fast.next == null) {
            while (slow!=null) {
                if (slow.val != p.val) {
                    return false;
                }
                slow = slow.next;
                p = p.next;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode p = l1;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(2);
//        p = p.next;
//        p.next = new ListNode(1);
        System.out.println(isPalindrome2(l1));
    }

}
