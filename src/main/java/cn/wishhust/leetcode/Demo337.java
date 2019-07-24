package main.java.cn.wishhust.leetcode;

public class Demo337 {

    //可以把根节点看作一个很特殊的节点。因为打劫直接相连的房子会引发报警，所以当打劫了根节点后，便不能打劫左右的子节点。那么，就可以把问题简化成打劫根节点与不打劫根节点中求最大值的问题。


    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 不包含根节点
        int exclusive = rob(root.left) + rob(root.right);

        // 包含根节点
        int include = root.val;
        if (null != root.left) {
            include += rob(root.left.left)+rob(root.left.right);
        }
        if (null != root.right) {
            include += rob(root.right.left)+rob(root.right.right);
        }

        return Math.max(exclusive,include);
    }
}
