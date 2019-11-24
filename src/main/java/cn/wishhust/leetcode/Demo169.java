package cn.wishhust.leetcode;

/**
 *
 * 169. ������
 *
 * ����һ����СΪ n �����飬�ҵ����е�������������ָ�������г��ִ�������?? n/2 ??��Ԫ�ء�
 *
 * ����Լ��������Ƿǿյģ����Ҹ������������Ǵ���������
 *
 * ʾ��?1:
 *
 * ����: [3,2,3]
 * ���: 3
 * ʾ��?2:
 *
 * ����: [2,2,1,1,1,2,2]
 * ���: 2
 *
 *
 */

public class Demo169 {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int currentNum = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (currentNum == nums[i]) {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                currentNum = nums[i];
            }
        }
        return currentNum;
    }
}
