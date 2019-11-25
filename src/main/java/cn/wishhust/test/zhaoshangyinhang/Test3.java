package cn.wishhust.test.zhaoshangyinhang;

import java.util.Scanner;

public class Test3 {
    public static int count = 0;
    public static char [] chars = {'A', 'B', 'C'};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        dps(n, 0, new StringBuilder());
        System.out.println(count);
    }


    public static void dps(int n, int step, StringBuilder s) {
        if (step == n) {
            if (!s.toString().contains("BBB") && !s.toString().contains("CC")) {
                count++;
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
                s.append(chars[i]);
                dps(n, step+1, s);
                s.deleteCharAt(s.length()-1);
        }
    }
}
