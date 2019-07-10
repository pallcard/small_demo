package main.java.cn.wishhust.test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] A = new int[n];
        int [] B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = scanner.nextInt();
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int score = 0;

        int aIndex = n - 1;
        int aIndex2 = 0;

        int bIndex = n - 1;
        int bIndex2 = 0;

        while (bIndex >= bIndex2) {
            if (A[aIndex] > B[bIndex]) {
                score++;
                aIndex--;
                bIndex--;
            } else if (A[aIndex] == B[bIndex]) {
                aIndex--;
                bIndex--;
            } else if (A[aIndex2] < B[bIndex2]){
                bIndex--;
                aIndex2++;
                score--;
            } else if (A[aIndex2] == B[bIndex2]) {
                aIndex2++;
                bIndex2++;
            } else if (A[aIndex2] > B[bIndex2]) {
                aIndex2++;
                bIndex2++;
                score++;
            }
        }
        System.out.println(score);
    }
}
