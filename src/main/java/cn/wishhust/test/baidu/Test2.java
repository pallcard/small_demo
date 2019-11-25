package cn.wishhust.test.baidu;

import java.util.Scanner;

public class Test2 {
    public static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        dfs(n, k);
        System.out.println(count);
    }
    public static void dfs(int n, int k) {
        if (n <= k+1 && n > 0) {
            count++;
            return;
        } else if(n <= 0) {
            return;
        }
        // 11 2
        // 5 1
        int l = 0;
        int r = 0;

        l = n/2+k/2;
        r = n/2-k/2;

        if (l + r != n) {
            count++;
            return;
        }
        dfs(l, k);
        dfs(r, k);

    }
}
