package main.java.cn.wishhust.leetcode;

public class Demo572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (null == s && null == t) {
            return true;
        }
        if (null == s || null == t) {
            return false;
        }

        if (s.val == t.val) {
            return isSubtree(s.left, t) || isSubtree(s.right,t) || isSubtreeWithRoot(s, t);
        } else  {
            return isSubtree(s.left, t) || isSubtree(s.right,t);
        }

    }


    public boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {
        if (null == s && null == t) {
            return true;
        }
        if (null == s || null == t) {
            return false;
        }
        if (s.val == t.val) {
            return isSubtreeWithRoot(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);
        }
        return false;
    }

}
