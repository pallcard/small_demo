package cn.wishhust.test.wangyi;

import java.util.Scanner;

public class Test01 {
    static void f(int num) {
        String bs = Integer.toBinaryString(num);
        int length = bs.length();
        for (int i = 0; i < length/2; i++) {
            if (bs.charAt(i) != bs.charAt(length-1-i)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=0;
        n = input.nextInt();
        int [] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = input.nextInt();
        }

        for(int j=0; j<a.length;j++) {
            f(a[j]);
        }

    }
}
