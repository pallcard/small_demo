package cn.wishhust.leetcode;

/**
 *
 * 200. 岛屿数量
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 */
public class Demo200 {

    public static int [][] direct = new int [][]{{0,-1},{-1,0},{0,1},{1,0}};

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    findByDFS(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public static void findByDFS(int x, int y, char [][] grid) {
        if (x < 0 || x >= grid.length
                || y < 0 || y >= grid[0].length
                || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';


        for (int i = 0; i < direct.length; i++) {
            int prex = x + direct[i][0];
            int prey = y + direct[i][1];
            findByDFS(prex, prey, grid);
        }
    }

}
