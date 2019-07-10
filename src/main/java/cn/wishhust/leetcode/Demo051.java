package main.java.cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Demo051 {
    private static void nQueen(int [] arr, int n, int step, List<List<String>> list) {
        if (step == n) {
            List<String> listStr = new ArrayList<String>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(".");
            }
            for (int i = 0; i < step; i++) {
                sb.replace(arr[i], arr[i]+1, "Q");
                listStr.add(sb.toString());
                sb.replace(arr[i], arr[i]+1, ".");
            }
            list.add(listStr);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check(arr, i, step)) {
                arr[step] = i;
                nQueen(arr, n,step+1, list);
            }
        }
    }

    private static boolean check(int [] arr, int t, int step) {
        for (int i = 0; i < step; i++) {
            if(t == arr[i] || Math.abs(step-i) == Math.abs(t-arr[i])) {
                return false;
            }
        }
        return true;
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<List<String>>();
        int [] arr = new int[n];
        nQueen(arr, n,0, list);
        return list;
    }

    public static void main(String[] args) {

        System.out.println(solveNQueens(1));
    }
}
