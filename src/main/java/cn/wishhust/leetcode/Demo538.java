package cn.wishhust.leetcode;

/**
 * 538. 把二叉搜索树转换为累加树
 *
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 *
 */

public class Demo538 {

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }

    // 反向中序遍历
    private void inOrder(TreeNode root) {
        if (null == root) {
            return;
        }

        inOrder(root.right);

        sum += root.val;

        root.val = sum;

//        if (null != root.right) {
//            root.val += root.right.val;
//        }
//        if (null != root.left) {
//            root.left.val += root.val;
//        }

        inOrder(root.left);


    }

}
