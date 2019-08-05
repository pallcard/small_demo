package cn.wishhust.leetcode;
public class Demo130 {

    public static int [][] direct = new int [][]{{0,-1},{-1,0},{0,1},{1,0}};

    public void solve(char[][] board) {

        if (board.length == 0) {
            return;
        }


        // 第一行和最后一行
        for (int i = 0; i < board[0].length; i++) {
            solve(board, 0, i);
            solve(board, board.length-1, i);
        }

        // 第一列和最后一列
        for (int i = 0; i < board.length; i++) {
            solve(board, i, 0);
            solve(board, i, board[0].length-1);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }


    public void solve(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'T';
        for (int i = 0; i < 4; i++) {
            solve(board, x + direct[i][0], y + direct[i][1]);
        }
    }

}
