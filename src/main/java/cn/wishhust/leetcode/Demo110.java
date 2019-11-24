package cn.wishhust.leetcode;

/**
 * 110. 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 *
 */
public class Demo110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left-right)>1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }


    // 第二种写法
    private boolean result = true;

    public boolean isBalanced2(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;
        int l = maxDepth2(root.left);
        int r = maxDepth2(root.right);
        if (Math.abs(l-r)>1) {
            result = false;
        }
        return Math.max(l,r)+1;
    }


}
