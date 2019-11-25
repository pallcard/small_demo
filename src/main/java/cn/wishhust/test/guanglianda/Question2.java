package cn.wishhust.test.guanglianda;

import java.util.Scanner;

public class Question2 {

    public static int direct[][] = {{0,-1}, {-1,0}, {0,1}, {1,0}};

    public static int m, n;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        char [][] chars = new char[m][n];

        for (int i = 0; i < m; i++) {
            if (chars[i][0] == 'O') {
                chars[i][0] = 'E';
                dfs(i,0,chars);
            }
            if (chars[i][n-1] == 'O') {
                chars[i][n-1] = 'E';
                dfs(i,n-1,chars);
            }
        }
        for (int i = 1; i < n-1; i++) {
            if (chars[0][i] == 'O') {
                chars[0][i] = 'E';
                dfs(0,i,chars);
            }
            if (chars[m-1][i] == 'O') {
                chars[m-1][i] = 'E';
                dfs(m-1,i,chars);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (chars[i][j] == 'E') {
                    chars[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(chars[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void dfs(int x, int y, char [][] chars) {
        for (int i = 0; i < 4; i++) {
            int x1 = x + direct[i][0];
            int y1 = y + direct[i][1];
            if (x1>=0 && x1<m && y1>=0 && y1<n && chars[x1][y1] == 'O') {
                chars[x1][y1] = 'E';
                dfs(x1,y1,chars);
            }
        }
    }
}
