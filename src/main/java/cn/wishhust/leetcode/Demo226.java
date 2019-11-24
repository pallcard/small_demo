package cn.wishhust.leetcode;

/**
 *
 * 226. ��ת������
 *
 * ��תһ�ö�������
 *
 * ʾ����
 *
 * ���룺
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * �����
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 */

public class Demo226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;



//        TreeNode left = root.left;
//        root.left = invertTree(root.right);
//        root.right = invertTree(left);
//        return root;
    }
}
