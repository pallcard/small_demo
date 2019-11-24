package cn.wishhust.leetcode;
import java.util.HashSet;
import java.util.Set;


/**
 * 217. �����ظ�Ԫ��
 *
 * ����һ���������飬�ж��Ƿ�����ظ�Ԫ�ء�
 *
 * ����κ�ֵ�������г����������Σ��������� true�����������ÿ��Ԫ�ض�����ͬ���򷵻� false��
 *
 * ʾ�� 1:
 *
 * ����: [1,2,3,1]
 * ���: true
 * ʾ�� 2:
 *
 * ����: [1,2,3,4]
 * ���: false
 * ʾ��?3:
 *
 * ����: [1,1,1,3,3,4,3,2,4,2]
 * ���: true
 *
 *
 */

public class Demo217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size() < nums.length;
    }
}
