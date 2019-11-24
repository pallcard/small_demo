package cn.wishhust.test.tongcheng58;

import java.util.Scanner;

public class Test3 {

    public static int [][] direct = new int [][]{{0,-1},{-1,0},{0,1},{1,0}};

    public static int max = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int [][] map = new int [m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        int path = map[0][0];
        dfs(0,0, map, path);
        System.out.println(max);
    }


    public static void dfs(int x, int y, int [][] grid, int path) {
        if (x == grid.length-1 && y == grid[0].length-1) {
            max = Math.min(max, path);
            return;
        }

        for (int i = 0; i < direct.length; i++) {
            int prex = x + direct[i][0];
            int prey = y + direct[i][1];
            if (prex >= 0 && prex < grid.length
                    && prey >= 0 && prey < grid[0].length && grid[prex][prey]>0) {
                int m = grid[prex][prey];
                grid[prex][prey] = -1;
                dfs(prex, prey, grid, path+ m);
                grid[prex][prey] = m;
            }
        }
    }
}
