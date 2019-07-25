package main.java.cn.wishhust.leetcode;

public class Demo530 {

    int min = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }

    private void inOrder(TreeNode root) {
        if(null == root) {
            return;
        }
        inOrder(root.left);
        if (null != pre) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;
        inOrder(root.right);
    }
}
