package cn.wishhust.leetcode;

public class Demo110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left-right)>1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }


    // 第二种写法
    private boolean result = true;

    public boolean isBalanced2(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;
        int l = maxDepth2(root.left);
        int r = maxDepth2(root.right);
        if (Math.abs(l-r)>1) {
            result = false;
        }
        return Math.max(l,r)+1;
    }


}
