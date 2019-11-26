package cn.wishhust.leetcode;

/**
 * 687. 最长同值路径
 *
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 * 示例 2:
 *
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 *
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 *
 */

public class Demo687 {
    int path = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return path;

    }

    public int dfs(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        int leftPath = 0, rightPath = 0;
        if (null != root.left && root.left.val == root.val) {
            leftPath = left + 1;
        }
        if (null != root.right && root.right.val == root.val) {
            rightPath = right + 1;
        }
        path = Math.max(path, leftPath+rightPath);
        return Math.max(leftPath, rightPath);
    }
}
