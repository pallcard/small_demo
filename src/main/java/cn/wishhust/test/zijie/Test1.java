package cn.wishhust.test.zijie;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] robots = new int [n];
        int maxIndex = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            robots[i] = scanner.nextInt();
        }
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (i < n-1 && robots[i] >= robots[i+1]) {
                cur++;
                int j = i + 1;
                while (j + 1 < n
                        && robots[j+1]>robots[j]
                        && robots[j+1] <= robots[i]) {
                    cur++;
                    j++;
                }
            }
            if (cur > max) {
                max = cur;
                maxIndex = i;
            }
            cur = 0;
        }
        if (max>0) {
            System.out.println(robots[maxIndex]);
        }
    }
}
