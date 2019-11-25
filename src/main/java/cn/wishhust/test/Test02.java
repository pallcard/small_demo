package cn.wishhust.test;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Test02 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int w = scanner.nextInt();
        int n = scanner.nextInt();
        int [] size = new int [n];
        int [] value = new int [n];
        int [] f = new int [w+1];

        for (int i = 0; i < n; i++) {
            size[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = w; j >= size[i]; j--) {
                f[j] = Math.max(f[j],f[j-size[i]]+value[i]);
            }
        }
        System.out.println(f[w]);
    }
}
