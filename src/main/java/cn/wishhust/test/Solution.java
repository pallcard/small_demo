package cn.wishhust.test;

import java.util.Scanner;

public class Solution {
    public static int [][] direct = new int [][]{{0,-1},{-1,0},{0,1},{1,0}};
    public static int max = 0;

    public static void find(int [][] arr,int x, int y, int k, int sdep) {
        if (k < 0) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int x1 = x + direct[i][0];
            int y1 = y + direct[i][1];
            if (x1>=0 && x1 < arr.length && y1>=0 && y1 < arr[0].length) {

                if (arr[x1][y1] > arr[x][y]) {
                    max = Math.max(max, sdep+1);
                    find(arr, x1, y1, k, sdep+1);
                } else if (k > 0) {
                    max = Math.max(max, sdep+1);
                    find(arr, x1, y1, k-1, sdep+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = scanner.nextInt();
        final int M = scanner.nextInt();
        final int K = scanner.nextInt();
        int [][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        find(arr, 0, 0, K, 1);
        System.out.println(max);
    }
}
