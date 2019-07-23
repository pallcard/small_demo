package main.java.cn.wishhust.leetcode;

public class Demo104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
//        return (maxDepth(root.left)>maxDepth(root.right))? maxDepth(root.left)+1 : maxDepth(root.right)+1 ;
    }

}
