package cn.wishhust.leetcode;


/**
 * 695. 岛屿的最大面积
 *
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 *
 */

public class Demo695 {


//    public static boolean [][] visited;
//
//    public static int maxAreaOfIsland(int[][] grid) {
//
//        visited = new boolean [grid.length][grid[0].length];
//        int min = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (!visited[i][j] && grid[i][j] == 1) {
//                    int temp = maxByDFS(i, j, grid);
//                    min = min > temp? min : temp;
//                }
//            }
//        }
//        return min;
//
//    }
//
//
//    public static int maxByDFS(int x, int y, int [][] grid) {
//
//        int min = 1;
//        for (int i = 0; i < 4; i++) {
//            int prex = x + direct[i][0];
//            int prey = y + direct[i][1];
//
//            if(prex >= 0 && prex < grid.length
//                    && prey >= 0 && prey < grid[0].length
//                    && grid[prex][prey] == 1 && !visited[prex][prey]) {
//                visited[prex][prey] = true;
//                min += maxByDFS(prex,prey,grid)+1;
//            }
//        }
//
//        return min;
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
