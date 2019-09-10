package cn.wishhust.test.wangyi;

import java.util.Scanner;

public class Test03 {

    public static boolean [] mon;
    public static int [] solution;
    public static int index = 0;

    public static void fun(int [] days, int k) {
        int count = 0;
        for (int i = 1; i < mon.length; i++) {
            if (mon[i]) {
                count++;
                continue;
            } else if(i == 1) {
                int j;
                for (j = 1; j <= k; j++) {
                    if (i + j < mon.length && mon[i+j]) {
                        break;
                    }
                }
                if (j == k+1) {
                    mon[i] = true;
                    count++;
                }
            } else {
                if (mon[i-1]) {
                    continue;
                }
                int j;
                for (j = 1; j <= k; j++) {
                    if (i + j < mon.length && mon[i+j]) {
                        break;
                    }
                }
                if (j == k+1) {
                    mon[i] = true;
                    count++;
                }
            }
        }
        solution[index++] = count;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        solution = new int [n];
        for (int i = 0; i < n; i++) {
            mon = new boolean [31];
            int k = scanner.nextInt();
            int m = scanner.nextInt();
            int [] days = new int [m];
            for (int j = 0; j < m; j++) {
                days[j] = scanner.nextInt();
                mon[days[j]] = true;
            }
            if (k == 0) {
                solution[index++] = 30;
            } else {
                fun(days,k);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(solution[i]);
        }
    }
}
