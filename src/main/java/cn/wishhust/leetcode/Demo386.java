package cn.wishhust.leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
