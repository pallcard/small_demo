package main.java.cn.wishhust.leetcode;

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
