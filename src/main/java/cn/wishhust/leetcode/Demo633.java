package main.java.cn.wishhust.leetcode;

public class Demo633 {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);
        while (i < j && i*i+j*j != c) {
            if (i*i+j*j < c) {
                i++;
            } else {
                j--;
            }
        }
        if (i*i+j*j == c) {
            return true;
        }
        return false;
    }
}
