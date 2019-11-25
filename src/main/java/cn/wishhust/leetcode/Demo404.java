package cn.wishhust.leetcode;

/**
 * 404. 左叶子之和
 *
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 *
 */
public class Demo404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (null == root) {
            return 0;
        }

        if (isLeaf(root.left)) {
            return root.left.val+ sumOfLeftLeaves(root.right);
        } else {
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }
    public boolean isLeaf(TreeNode p) {
        if(p == null) {
            return false;
        }
//        if (null == p.left && null == p.right) {
//            return true;
//        }
//        return false;
        return null == p.left && null == p.right;
    }
}
