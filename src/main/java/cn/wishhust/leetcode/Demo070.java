package cn.wishhust.leetcode;

public class Demo070 {

    public static int climbStairs(int n) {

        int sum = 0;

//        if (n == 1)
//            return 1;
//        if (n == 2)
//            return 2;
//        else {
//            return climbStairs(n-1) + climbStairs(n-2);
//        }

        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int pre1 = 1;
        int pre2 = 2;

        for (int i = 2; i < n; i++) {
            sum = pre1 + pre2;
            pre1 = pre2;
            pre2 = sum;
        }

        return sum;

    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

}
