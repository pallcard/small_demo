package main.java.cn.wishhust.leetcode;

import java.util.Arrays;

public class Demo725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int lenght = 0;
        ListNode p = root;
        while (p != null) {
            lenght++;
            p = p.next;
        }
        ListNode [] list = new ListNode[k];

        int [] listLength = new int[k];
        Arrays.fill(listLength, lenght/k);
        for (int i = 0; i < lenght%k; i++) {
            listLength[i]++;
        }
        p = root;
        for (int i = 0; i < k && listLength[i]>0; i++) {
            list[i] = p;
            for (int j = 0; j < listLength[i]-1; j++) {
                p = p.next;
            }
            ListNode q = p;
            p = p.next;
            q.next = null;
        }
        return list;
    }
}
