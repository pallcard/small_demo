package cn.wishhust.leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 386. �ֵ�������
 * ����һ������?n, ���ش�?1?��?n?���ֵ�˳��
 *
 * ���磬
 *
 * ���� n =1 3������ [1,10,11,12,13,2,3,4,5,6,7,8,9] ��
 *
 * �뾡���ܵ��Ż��㷨��ʱ�临�ӶȺͿռ临�Ӷȡ� ���������?n?С�ڵ���?5,000,000��
 *
 */

// dfs
//                  100
//        10   ---> 101
//        11        ...
//        12
//1 --->  ...
//        17
//        18
//        19
public class Demo386 {
    public List<Integer> lexicalOrder(int n) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(n, i, list);
        }
        return list;
    }

    private void dfs(int n, int target, List<Integer> list) {
        if (target > n) {
            return;
        }
        list.add(target);
        target *= 10;
        for (int i = 0; i < 10; i++) {
            dfs(n, target + i, list);
        }
    }


}
