package main.java.cn.wishhust.test;

import java.util.Scanner;

public class Test03 {

    public static int count=0;
    public static int m = 0;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        m = scanner.nextInt();
        int a [] = new int [n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        permutation(a,0);
        System.out.println(count);
    }

    public static void permutation(int [] a, int i) {
        if (i < 0 || i > a.length) {
            return;
        }
        if (i == a.length-1){
            int k = 0;
            for (k = 0; k < a.length-1; k++) {
                if (Math.abs(a[k]-a[k+1]) > m) {
                    break;
                }
            }
            if (k == a.length-1 && Math.abs(a[0]-a[a.length-1]) <= m) {
                count++;
            }

        } else {
            for (int j = i; j < a.length; j++) {
                int t = a[j];
                a[j] = a[i];
                a[i] = t;
                permutation(a,i+1);
                t = a[j];
                a[j] = a[i];
                a[i] = t;
            }
        }
    }
}
