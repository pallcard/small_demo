package cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * DFS, 每一个皇后有n种方法放置。对放入的皇后做check，
 * 在同一条对角线上：(i,j) (x,y) ===> Math.abs(x-i) == Math.abs(y-j)
 * 在同一水平线和垂直线上： x==i || y==j
 * 让二维压缩到一维，用一个数组存放即可
 */
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
