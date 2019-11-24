package cn.wishhust.leetcode;

/**
 * 104. ��������������
 *
 * ����һ�����������ҳ��������ȡ�
 *
 * �����������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����
 *
 * ˵��:?Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 *
 * ʾ����
 * ���������� [3,9,20,null,null,15,7]��
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ��������������?3
 *
 */
public class Demo104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
//        return (maxDepth(root.left)>maxDepth(root.right))? maxDepth(root.left)+1 : maxDepth(root.right)+1 ;
    }

}
