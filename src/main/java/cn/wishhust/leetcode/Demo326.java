package cn.wishhust.leetcode;
public class Demo326 {

    public static  boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        } if (n == 1) {
            return true;
        }
        while (n >= 3) {
            if (n / 3 == 1 && n % 3 ==0) {
                return true;
            } else if (n % 3 == 0) {
                n /= 3;
            } else {
                return false;
            }
        }
        return false;
//        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
//        return n > 0 && (1162261467 % n == 0);
    }


    public static void main(String[] args) {
        isPowerOfThree(19684);
    }
}
