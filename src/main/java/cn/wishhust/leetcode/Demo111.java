package cn.wishhust.leetcode;

/**
 * 111. ����������С���
 * ����һ�����������ҳ�����С��ȡ�
 *
 * ��С����ǴӸ��ڵ㵽���Ҷ�ӽڵ�����·���ϵĽڵ�������
 *
 * ˵��:?Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 *
 * ʾ��:
 *
 * ����������?[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ����������С��� ?2.
 *
 */
public class Demo111 {

//    public int minDepth(TreeNode root) {
//        if (null == root) {
//            return 0;
//        }
//
//
//
//        int min = Integer.MIN_VALUE;
//        min = Math.min(minDepth(root.left), minDepth(root.right))+1;
//        return min;
//
//
//    }
//
//    public int minDepthStartWithRoot(TreeNode root) {
//        if (null == root.left && null == root.right) {
//            return 1;
//        }
//        if (null == root.left || null == root.right) {
//
//        }
//    }

    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return left+right+1;
        }
        return Math.min(left, right)+1;
    }

}
