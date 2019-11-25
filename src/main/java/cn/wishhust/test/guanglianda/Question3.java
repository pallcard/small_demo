package cn.wishhust.test.guanglianda;

public class Question3 {
    public static Node findPos(Node head) {
        Node p = head, q = head;
        if (head.next == null || head.next.next == null) {
            return null;
        }
        p = p.next;
        q = q.next.next;
        while (p !=  q && p!= null && q!= null) {
            p = p.next;
            if (q.next != null) {
                q = q.next.next;
            } else {
                return null;
            }
        }
        if (p == q) {
            return p;
        } else {
            return null;
        }
    }
}

class Node {
    int value;
    Node next;
}
