package cn.wishhust.leetcode;

/**
 *
 * 326. 3的幂
 *
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 * 示例 4:
 *
 * 输入: 45
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 *
 *
 */


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
