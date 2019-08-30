package cn.wishhust.test;

public class Test3 {

    public static void main(String[] args) {

        Node head = new Node (0, null);
        Node r = head;

        for (int i = 1; i <= 10; i++) {
            Node node = new Node(i, null);

            r.next = node;
            r = r.next;
        }

        Node p = head;
        while (p != null) {
            System.out.print(p.value+" ");
            p = p.next;
        }



    }

}

class Node {
    int value;
    Node next;

    public Node(int value, Node next) {

        this.value = value;
        this.next = next;
    }
}
