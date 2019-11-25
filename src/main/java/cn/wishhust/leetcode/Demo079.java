package cn.wishhust.leetcode;

/**
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 * dfs
 */
public class Demo079 {

    public static int [][] direct = new int [][]{{0,-1},{-1,0},{0,1},{1,0}};

    public boolean exist(char[][] board, String word) {

        boolean [][] visited = new boolean [board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    // 这样的处理方法，只要存在true就返回true
                    if (exist(board, visited, word, i, j,1)) {
                        return true;
                    }
                    // 回溯
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, boolean[][] visited, String word,int x, int y, int k) {

        if (k == word.length()) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            int x1 = x + direct[i][0];
            int y1 = y + direct[i][1];
            if (x1>=0 && x1 < board.length && y1>=0 && y1 < board[0].length && board[x1][y1] == word.charAt(k) && !visited[x1][y1]) {
                visited[x1][y1] = true;
                if (exist(board, visited, word, x1, y1,k+1)) {
                    return true;
                }
                visited[x1][y1] = false;
            }
        }
        return false;

    }

}
