package cn.wishhust.test.shunfeng;

import java.util.Scanner;

public class Test1 {

    private static int root(int[] roots, int i) {
        while (roots[i] != i) i = roots[roots[i]];
        return i;
    }
    public static int countComponents(int n, int[][] edges) {
        int count = n;
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) roots[i] = i;
        for (int i = 0; i < edges.length; i++) {
            int r1 = root(roots, edges[i][0]);
            int r2 = root(roots, edges[i][1]);
            if (r1 != r2) {
                roots[r2] = r1;
                count--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int m = scanner.nextInt();
        final int k = scanner.nextInt();
        int [][] info = new int [k][2];
        int [][] r = new int [n][m];
        for (int i = 0; i < k; i++) {
            info[i][0] = scanner.nextInt();
            info[i][1] = scanner.nextInt();
            r[info[i][0]-1][info[i][1]-1] = 1;
        }


        System.out.println(countComponents(m,r));
    }
}
