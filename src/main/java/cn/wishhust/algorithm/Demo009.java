package main.java.cn.wishhust.algorithm;

/**
 * 斐波那契数列，
 *  应用1：矩形覆盖
 *  n个2*1小矩形覆盖2*n的大矩形，有多少种方法
 *  应用2：跳台阶
 *  可以跳1列或者2列，跳n阶   有多少种方法
 *
 */
public class Demo009 {

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
        System.out.println(fibonacci2(10));
        System.out.println(fibonacci3(10));
    }


    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else
            return  fibonacci(n-1) + fibonacci(n-2);
    }

//    0 1 2 3 4 5 6 7  8  9  10
//    0 1 1 2 3 5 8 13 21 34 55
    public static int fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }
        int [] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

    public static int fibonacci3(int n) {
        if (n <= 1) {
            return n;
        }
        int temp1 = 0, temp2 = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = temp1 + temp2;
            temp1 = temp2;
            temp2 = result;
        }
        return result;
    }

}
