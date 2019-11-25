package cn.wishhust.test.guanglianda;

import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println(1);
        }
        int feizi = 1;
        int feimu = 1;
        for (int i = 1; i < n; i++) {
            feizi = 2*feizi+1;
            feimu = 2*feimu;
        }
        System.out.println(feizi +"/"+ feimu);
    }
}
