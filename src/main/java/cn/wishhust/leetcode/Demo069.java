package cn.wishhust.leetcode;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 *
 */
public class Demo069 {
    public static int mySqrt(int x) {

        if (x == 1) {
            return 1;
        }
        int i = 1;
        while (i <= x/2) {

            // i*i可能超出int范围
            if (i*i>x || i*i < 0) {
                return i -1;
            } else {
                i++;
            }

/*            if (i * i <= x) {
                i++;
            } else {
                return i-1;
            }*/
        }
        return i-1;
    }



    // 牛顿迭代法
    int s;

    public int mySqrt2(int x) {
        s=x;
        if(x==0) return 0;
        return ((int)(sqrts(x)));
    }

    public double sqrts(double x){
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrts(res);
        }
    }


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(mySqrt(2147395600));
    }

}
