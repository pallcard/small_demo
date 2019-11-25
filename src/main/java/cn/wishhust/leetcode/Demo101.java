package cn.wishhust.leetcode;

/**
 *
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 */

public class Demo101 {
    public boolean isSymmetric(TreeNode root) {

        if (null == root) {
            return true;
        }

        return isSymmetric(root.left,root.right);
    }


    public boolean isSymmetric(TreeNode s, TreeNode t) {
        if (null == s && null == t) {
            return true;
        }
        if (null == s || null == t) {
            return false;
        }

        if (s.val == t.val) {
            return isSymmetric(s.left, t.right) && isSymmetric(s.right, t.left);
        } else {
            return false;
        }
    }


}
