package cn.wishhust.leetcode;

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
