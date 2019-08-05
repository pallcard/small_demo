package cn.wishhust.leetcode;
public class Demo112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }
        if (null == root.left && null == root.right && sum == root.val) {
            return true;
        }
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);

    }
}
