package cn.wishhust.test.dianxing;

import org.apache.tools.ant.filters.EscapeUnicode;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int n = scanner.nextInt();
        int [] a = new int [n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        Arrays.sort(a);

        System.out.println(a[n/2]);

    }
}
