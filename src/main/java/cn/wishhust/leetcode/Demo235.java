package main.java.cn.wishhust.leetcode;

public class Demo235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode t = p;
            p = q;
            q = t;
        }
        if (p.val <= root.val && root.val <= q.val) {
            return root;
        } else if(p.val < root.val && root.val > q.val) {
            return lowestCommonAncestor(root.left,p,q);
        } else {
            return lowestCommonAncestor(root.right,p,q);
        }
    }
}

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) {val = x;}
//}
