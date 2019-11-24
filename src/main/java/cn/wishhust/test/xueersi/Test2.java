package cn.wishhust.test.xueersi;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] a = new int [n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int sum = (int)(n * 0.001);


        for (int i = 0; i <= sum; i++) {
            System.out.println(a[n-i-1]);
        }
    }
}
