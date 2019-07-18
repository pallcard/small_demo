package main.java.cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Demo077 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> string = new ArrayList<>();
        boolean [] visited = new boolean [n+1];
        combine(n, k, list, string, visited, 0);
        return list;
    }

    public static void combine(int n, int k, List<List<Integer>> list, List<Integer> string, boolean [] visited, int step) {
        if (step == k) {
            list.add(new ArrayList<>(string));
            return;
        }

        int index = 1;
        if (string.size()>0 && string.get(string.size()-1)>index) {
            index = string.get(string.size()-1);
        }

        for (int i = index; i < n+1; i++) {

            if (!visited[i]) {
                visited[i] = true;
                string.add(i);
                combine(n, k, list, string, visited, step+1);
                visited[i] = false;
                string.remove(string.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }

}
