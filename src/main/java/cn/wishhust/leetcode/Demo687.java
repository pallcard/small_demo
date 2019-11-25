package cn.wishhust.leetcode;
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
