package cn.wishhust.leetcode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 232. 用栈实现队列
 *
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * 说明:
 *
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 */

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
