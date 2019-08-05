package cn.wishhust.leetcode;

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
