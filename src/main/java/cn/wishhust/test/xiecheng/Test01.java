package cn.wishhust.test.xiecheng;

import java.util.Scanner;

public class Test01 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head,int m) {
        ListNode h = new ListNode(m);

        ListNode p = head, pre = head, r = h;

        while(p != null) {
            if (p.val > m) {
                pre = p;
                p = p.next;
            } else {
                if (pre == p) {
                    r.next = p;
                    p = p.next;
                    pre = p;
                } else {
                    pre.next = p.next;
                    r.next = p;
                    p = p.next;
                    r = r.next;
                }
            }
        }
        r.next = head;
        return h.next;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}
