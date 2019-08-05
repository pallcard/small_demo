package cn.wishhust.leetcode;
import java.util.*;

public class Demo440 {
    // 方法一超时
    public int findKthNumber1(int n, int k) {
        List<Set<String>> list = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            list.add(new TreeSet<>());
        }
        for (int i = 1; i <= n; i++) {
            if (n % 10 == 0) {

            }
            int temp = String.valueOf(i).charAt(0)-'0';
            list.get(temp-1).add(String.valueOf(i));
        }
        int index = 0;
        while (list.get(index).size() < k) {
            k -= list.get(index).size();
            index++;
        }

        Iterator<String> iterator = list.get(index).iterator();
        while (k-->0) {
            iterator.next();
        }
        return Integer.parseInt(iterator.next());
    }


    // 方法超时
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k>0) {
            int first = cur, last = cur+1, count = 0;
            while (first <= n) {
                count += Math.min(n+1,last)-first;
                first = first*10;
                last = last*10;
            }
            // 在子树里面
            if (count >= k) {
                cur *= 10;
                k--;
            // 不在子树里面
            } else {
                cur++;
                k -= count;
            }
        }
        return cur;
    }

}
