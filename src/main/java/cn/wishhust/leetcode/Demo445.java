package main.java.cn.wishhust.leetcode;

import java.util.Stack;

public class Demo445 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.add(l1.val);
            l1 = l1.next;
        }

        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
        }

        ListNode head = new ListNode(0);
        int d = 0;
        while (!stack1.empty() && !stack2.empty()) {
            int a = stack1.pop();
            int b = stack2.pop();


            if (head.next == null) {
                head.next = new ListNode((a+b+d)%10);
            } else {
                ListNode temp = new ListNode((a+b+d)%10);
                temp.next = head.next;
                head.next = temp;
            }

            d = (a+b+d)/10;
        }



        while (!stack1.empty()) {
            int a = stack1.pop();
            ListNode temp = new ListNode((a+d)%10);
            temp.next = head.next;
            head.next = temp;
            d = (a+d)/10;

        }

        while (!stack2.empty()) {
            int a = stack2.pop();
            ListNode temp = new ListNode((a+d)%10);
            temp.next = head.next;
            head.next = temp;
            d = (a+d)/10;

        }
        if (d>0) {
            ListNode temp = new ListNode(d);
            temp.next = head.next;
            head.next = temp;
        }


        return head.next;


    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode p = l1;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        p = l2;
        p.next = new ListNode(6);
        p = p.next;
        p.next = new ListNode(4);

        addTwoNumbers(l1, l2);
    }

}
