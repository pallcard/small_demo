package cn.wishhust.leetcode;
public class Demo543 {
//    public int diameterOfBinaryTree(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        return Math.min(diameterOfBinaryTree2(root.left),diameterOfBinaryTree2(root.right));
//
//
//
//    }
//
//    public int diameterOfBinaryTree2(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        return maxDepth(root.left) + maxDepth(root.right)+1;
//    }
//
//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return Math.min(maxDepth(root.left), maxDepth(root.right))+1;
//    }

    public int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;

    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        // 路径长度，边的个数
        max = Math.max(max, l+r);
        return Math.max(l,r)+1;
    }
}
