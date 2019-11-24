package cn.wishhust.leetcode;

/**
 * 167. ����֮�� II - ������������
 *
 * ����һ���Ѱ�����������?���������飬�ҵ�������ʹ���������֮�͵���Ŀ������
 *
 * ����Ӧ�÷����������±�ֵ index1 �� index2������ index1?����С��?index2��
 *
 * ˵��:
 *
 * ���ص��±�ֵ��index1 �� index2�����Ǵ��㿪ʼ�ġ�
 * ����Լ���ÿ������ֻ��ӦΨһ�Ĵ𰸣������㲻�����ظ�ʹ����ͬ��Ԫ�ء�
 * ʾ��:
 *
 * ����: numbers = [2, 7, 11, 15], target = 9
 * ���: [1,2]
 * ����: 2 �� 7 ֮�͵���Ŀ���� 9 ����� index1 = 1, index2 = 2 ��
 *
 *
 */

public class Demo167 {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while (i < j && numbers[i] + numbers[j] != target) {

            if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }

//        if (numbers[i] + numbers[j] == target) {
            return new int[]{i+1, j+1};
//        }
    }
}
