package main.java.cn.wishhust.leetcode;

public class Demo111 {

    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }



        int min = Integer.MIN_VALUE;
        min = Math.min(minDepth(root.left), minDepth(root.right))+1;
        return min;


    }

    public int minDepthStartWithRoot(TreeNode root) {
        if (null == root.left && null == root.right) {
            return 1;
        }
        if (null == root.left || null == root.right) {

        }
    }

}
