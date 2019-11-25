package cn.wishhust.leetcode;

/**
 * 100. 相同的树
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 *
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
