package cn.wishhust.leetcode;

/**
 * 338. ����λ����
 * ����һ���Ǹ�����?num������?0 �� i �� num ��Χ�е�ÿ������?i?����������������е� 1 ����Ŀ����������Ϊ���鷵�ء�
 *
 * ʾ�� 1:
 *
 * ����: 2
 * ���: [0,1,1]
 * ʾ��?2:
 *
 * ����: 5
 * ���: [0,1,1,2,1,2]
 * ����:
 *
 * ����ʱ�临�Ӷ�ΪO(n*sizeof(integer))�Ľ��ǳ����ס��������������ʱ��O(n)����һ��ɨ��������
 * Ҫ���㷨�Ŀռ临�Ӷ�ΪO(n)��
 * ���ܽ�һ�����ƽⷨ��Ҫ����C++���κ����������в�ʹ���κ����ú������� C++ �е�?__builtin_popcount����ִ�д˲�����
 *
 *
 */

public class Demo338 {

    public static int[] countBits(int num) {
        int [] dp = new int [num+1];

        if (num == 0) {
            return dp;
        }

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= num; i++) {
            double exp =  Math.floor(Math.log(i)/Math.log(2));
            int index = (int) (i-Math.pow(2, exp));
            dp[i] = dp[index]+1;
        }
        return dp;
    }

    public static void main(String[] args) {

        System.out.println(countBits(5));

    }
}
