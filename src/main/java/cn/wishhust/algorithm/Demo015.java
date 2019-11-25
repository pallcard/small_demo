package cn.wishhust.algorithm;

/**
 * 二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数
 *
 * n&(n-1)会去除掉n的位级表示中的最低的一位
 */
public class Demo015 {

    public static int numberOf1(int n) {
        int count = 0;

        if (n == 0) {
            return 0;
        }

        while (n != 0) {
            count++;
            n &= (n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1(10));
        System.out.println(Integer.bitCount(10));
    }
}
