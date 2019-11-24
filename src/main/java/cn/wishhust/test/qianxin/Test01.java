package cn.wishhust.test.qianxin;

import java.util.Scanner;

public class Test01 {
    /*������������������ʵ����ĿҪ��Ĺ���
��Ȼ����Ҳ���Բ������������ģ����������ȫ�����Լ����뷨�� ^-^
******************************��ʼд����******************************/
    static int smallestRange(int [] nums, double avg, int k) {
        if (nums.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > avg) {
                nums[i] -= k;
            } else {
                nums[i] += k;
            }
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max - min;
    }
    /******************************����д����******************************/

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        String[] s = str.split(" ");
        int [] nums = new int [s.length];
        double avg = 0.0;
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
            avg += nums[i];
        }
        avg /= nums.length;

        int res;

        res = smallestRange(nums, avg, k);
        System.out.println(String.valueOf(res));

    }
}
