package cn.wishhust.leetcode;

/**
 * 108. ����������ת��Ϊ����������
 *
 * ��һ�������������е��������飬ת��Ϊһ�ø߶�ƽ�������������
 *
 * �����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ�?���������������ĸ߶Ȳ�ľ���ֵ������ 1��
 *
 * ʾ��:
 *
 * ������������: [-10,-3,0,5,9],
 *
 * һ�����ܵĴ��ǣ�[0,-3,9,-10,null,5]�������Ա�ʾ��������߶�ƽ�������������
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 *
 */
public class Demo108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length-1);
    }

    private TreeNode toBST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums, low, mid-1);
        root.right = toBST(nums, mid+1, high);
        return root;
    }
}
