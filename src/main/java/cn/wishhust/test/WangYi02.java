package cn.wishhust.test;

public class WangYi02 {
    public static void main(String[] args) {
        int m =10000, t = 1000, m1 = 10, t1 = 5, m2 = 5, t2 = 3;

        int result = 0;
        boolean in = true;
        boolean out = true;
        for (int i = 0; i < t; i++) {
            if (i != 0) {
                if (i % t1 == 0) {
                    in = !in;
                }
                if (i % t2 == 0) {
                    out = !out;
                }
            }


            if (out && in) {
                result += (m1-m2);
                result = result<0?0:result;
                result = result>m?m:result;
            } else if (in) {
                result += m1;
                result = result>m?m:result;
            } else if (out) {
                result -= m2;
                result = result<0?0:result;
            }
        }
        System.out.println(result);
    }
}
