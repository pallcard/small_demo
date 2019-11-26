package cn.wishhust.leetcode;

/**
 * 543. 二叉树的直径
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 *
 */

public class Demo543 {
//    public int diameterOfBinaryTree(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        return Math.min(diameterOfBinaryTree2(root.left),diameterOfBinaryTree2(root.right));
//
//
//
//    }
//
//    public int diameterOfBinaryTree2(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        return maxDepth(root.left) + maxDepth(root.right)+1;
//    }
//
//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return Math.min(maxDepth(root.left), maxDepth(root.right))+1;
//    }

    public int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;

    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        // 路径长度，边的个数
        max = Math.max(max, l+r);
        return Math.max(l,r)+1;
    }
}
