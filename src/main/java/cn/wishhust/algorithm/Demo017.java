package cn.wishhust.algorithm;


/**
 *
 * n皇后问题
 *
 */

public class Demo017 {

    public static int k = 4;
    public static int count = 0;

    private static void nQueen(int [] arr, int n) {
        if (n == k) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]+1+" ");
            }
            System.out.println();
            count++;
            return;
        }

        for (int i = 0; i < k; i++) {
            if (check(arr, i, n)) {
                arr[n] = i;
                nQueen(arr, n+1);
            }
        }
    }

    private static boolean check(int [] arr, int t, int n) {
        for (int i = 0; i < n; i++) {
            if(t == arr[i] || Math.abs(n-i) == Math.abs(t-arr[i])) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        // NQueen
        int [] arr = new int[k];
        nQueen(arr, 0);
        System.out.println(count);

    }
}
