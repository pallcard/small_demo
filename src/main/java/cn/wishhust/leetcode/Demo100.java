package main.java.cn.wishhust.leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Demo100 {


    public boolean isSameTree(TreeNode p, TreeNode q) {

//        if(p == null && q==null) {
//            return true;
//        } else if (p != null && q != null) {
//
//            if (p.left == null && p.right == null && q.right == null && q.left == null && p.val == q.val) {
//                return true;
//            }
//
//            boolean left = true, right = true;
//            if (p.left != null && q.left != null) {
//                left = isSameTree(p.left,q.left);
//            } else if(p.left == null && q.left == null){
//
//            } else {
//                return false;
//            }
//
//            if (p.right != null && q.right != null) {
//                right = isSameTree(p.right,q.right);
//            }else if(p.right == null && q.right == null){
//
//            } else {
//                return false;
//            }
//            return  left && right;
//
//        }
//
//        return false;

        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if(p.val != q.val){
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
        }

    }



}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}
