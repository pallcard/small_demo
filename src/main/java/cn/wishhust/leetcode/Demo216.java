package cn.wishhust.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * 216. ����ܺ� III
 *
 * �ҳ��������֮��Ϊ?n ��?k?��������ϡ������ֻ������ 1 -?9 ��������������ÿ������в������ظ������֡�
 *
 * ˵����
 *
 * �������ֶ�����������
 * �⼯���ܰ����ظ�����ϡ�?
 * ʾ�� 1:
 *
 * ����: k = 3, n = 7
 * ���: [[1,2,4]]
 * ʾ�� 2:
 *
 * ����: k = 3, n = 9
 * ���: [[1,2,6], [1,3,5], [2,3,4]]
 *
 */

public class Demo216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        boolean [] visited = new boolean[10];
        combinationSum3(k, n,list,integers, visited, 1);
        return list;
    }

    public static void combinationSum3(int k, int target, List<List<Integer>> list, List<Integer> integers, boolean [] visited, int index) {

        if (target == 0 && 0 == k) {
            list.add(new ArrayList<>(integers));
            return;
        } else if (target < 0 || 0 > k) {
            return;
        }

        for (int i = index; i < 10; i++) {
            if (target >= i && !visited[i]) {
                visited[i] = true;
                integers.add(i);
                combinationSum3(k-1, target-i, list, integers, visited, i);
                integers.remove(integers.size()-1);
                visited[i] = false;
            }
        }
    }
}
