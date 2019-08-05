package cn.wishhust.leetcode;

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
