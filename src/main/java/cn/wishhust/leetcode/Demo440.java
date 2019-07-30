package main.java.cn.wishhust.leetcode;

import java.util.*;

public class Demo440 {
    // 方法一超时
    public int findKthNumber1(int n, int k) {
        Object
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

//    int i, j;
//    vector<vector<int>> f (n, vector < int>(n)),s(n, vector < int>(n));
//    //f[i][j]代表绝顶聪明的人从arr[i]到arr[j]先拿可以得到的分数，s[i][j]代表后拿可以得到的分数
//    //对f和s赋值
//        for (j = 0; j < n; ++j) {
//        f[j][j] = arr[j];//i==j,先拿的人只有一种选择，就是arr[i]
//        s[j][j] = 0;//i==j,后拿的人没有纸牌可拿
//        for (i = j - 1; i >= 0; --i) {//计算的方向是每一列从下往上,先计算行，后计算列
//            f[i][j] = max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
//            //先拿的人有两种选择，如果拿arr[i]，那么对于arr[i+1]到arr[j]就成了后拿；如果拿arr[j]那么对于arr[i]到arr[j-1]就成了后拿，选择最优的。
//            s[i][j] = min(f[i + 1][j], f[i][j - 1]);//在A拿完之后，B成了先拿的人，但是A会给B剩下一种最差的方案，也就是在f[i+1][j]和f[i][j-1]中选择最小的一个
//        }
//    }
//    //返回f和s中较大的一个
//        return max(f[0][n - 1], s[0][n - 1]);



    public static int cardGame(int[] A, int n) {


        // f[i][j]表示在牌[i...j]下，先选能获得的最大分数
        // s[i][j]表示在牌[i...j]下，后选能获得的最大分数
        int[][] f = new int[n][n];
        int[][] s = new int[n][n];
        for (int j = 0; j < n; j++) {
            f[j][j] = A[j];   //i==j,先拿的人只有一种选择，就是arr[i]
            s[j][j] = 0;      //i==j,后拿的人没有纸牌可拿
            //计算的方向是每一列从下往上,先计算行，后计算列
            for (int i = j - 1; i >= 0; i--) {
                // 先拿的人有两种选择，如果拿arr[i]，那么对于arr[i+1]到arr[j]就成了后拿；如果拿arr[j]那么对于arr[i]到arr[j-1]就成了后拿，选择最优的。
                f[i][j] = Math.max(A[i] + s[i + 1][j], A[j] + s[i][j - 1]);
                //在A拿完之后，B成了先拿的人，但是A会给B剩下一种最差的方案，也就是在f[i+1][j]和f[i][j-1]中选择最小的一个
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]); // 后手只能获得较小的分数
            }
        }
        return Math.max(f[0][n - 1], s[0][n - 1]);


    }
}
