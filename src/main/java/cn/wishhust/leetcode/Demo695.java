package main.java.cn.wishhust.leetcode;

public class Demo695 {


//    public static boolean [][] visited;
//
//    public static int maxAreaOfIsland(int[][] grid) {
//
//        visited = new boolean [grid.length][grid[0].length];
//        int max = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (!visited[i][j] && grid[i][j] == 1) {
//                    int temp = maxByDFS(i, j, grid);
//                    max = max > temp? max : temp;
//                }
//            }
//        }
//        return max;
//
//    }
//
//
//    public static int maxByDFS(int x, int y, int [][] grid) {
//
//        int max = 1;
//        for (int i = 0; i < 4; i++) {
//            int prex = x + direct[i][0];
//            int prey = y + direct[i][1];
//
//            if(prex >= 0 && prex < grid.length
//                    && prey >= 0 && prey < grid[0].length
//                    && grid[prex][prey] == 1 && !visited[prex][prey]) {
//                visited[prex][prey] = true;
//                max += maxByDFS(prex,prey,grid)+1;
//            }
//        }
//
//        return max;
//    }
    public static int [][] direct = new int [][]{{0,-1},{-1,0},{0,1},{1,0}};

    public static int m = 0;
    public static int n = 0;

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int temp = maxByDFS(i, j, grid);
                    maxArea = maxArea > temp ? maxArea : temp;
                }
            }
        }
        return maxArea;

    }

    public static int maxByDFS(int x, int y, int[][] grid) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0) {
            return 0;
        }

        grid[x][y] = 0;
        int area = 1;
        for (int i = 0; i < 4; i++) {
            int prex = x + direct[i][0];
            int prey = y + direct[i][1];
            area += maxByDFS(prex, prey, grid);
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,1,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        }));
    }

}
