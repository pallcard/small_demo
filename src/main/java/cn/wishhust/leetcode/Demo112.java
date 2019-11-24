package cn.wishhust.leetcode;

/**
 * 112. ·���ܺ�
 * ����һ����������һ��Ŀ��ͣ��жϸ������Ƿ���ڸ��ڵ㵽Ҷ�ӽڵ��·��������·�������нڵ�ֵ��ӵ���Ŀ��͡�
 *
 * ˵��:?Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 *
 * ʾ��:?
 * �������¶��������Լ�Ŀ��� sum = 22��
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * ���� true, ��Ϊ����Ŀ���Ϊ 22 �ĸ��ڵ㵽Ҷ�ӽڵ��·�� 5->4->11->2��
 *
 *
 */


public class Demo112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }
        if (null == root.left && null == root.right && sum == root.val) {
            return true;
        }
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);

    }
}
