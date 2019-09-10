package cn.wishhust.test.xiaohongshu;

import java.util.Scanner;

public class Test01 {

    public static int [][] dirc = new int [][] {{-1, 0},{0, -1},{1,0},{0, 1}};

    public static int n, m;

    public static int min;

    public static void dps(int [][] map, int x, int y, int step) {
        if (x == n-1 && y == m-1) {
            min = Math.min(min, step);
        }

        for (int i = 0; i < 4; i++) {
            int xx = x + dirc[i][0];
            int yy = y + dirc[i][1];
            if (xx >= 0 && yy >= 0 && xx <= n-1 && yy <= m-1 && map[xx][yy] == 0) {
                map[xx][yy] = 1;
                dps(map, xx, yy, step+1);
                map[xx][yy] = 0;
            }
        }


    }


    public static void main(String[] args) {
        int k;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        min = m*n;
        int [][] map = new int [n][m];

        int tempX, tempY;
        for (int i = 0; i < k; i++) {
            tempX = scanner.nextInt();
            tempY = scanner.nextInt();
            map[tempX][tempY] = 1;
        }

        dps(map, 0, 0, 0);

        System.out.println(min);

    }

}
