package cn.wishhust.leetcode;

/**
 *
 * 322. ��Ǯ�һ�
 *
 * ������ͬ����Ӳ�� coins ��һ���ܽ�� amount����дһ��������������Դճ��ܽ����������ٵ�Ӳ�Ҹ��������û���κ�һ��Ӳ�����������ܽ�����?-1��
 *
 * ʾ��?1:
 *
 * ����: coins = [1, 2, 5], amount = 11
 * ���: 3
 * ����: 11 = 5 + 5 + 1
 *
 * ʾ�� 2:
 *
 * ����: coins = [2], amount = 3
 * ���: -1
 * ˵��:
 * �������Ϊÿ��Ӳ�ҵ����������޵ġ�
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
