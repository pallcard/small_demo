package main.java.cn.wishhust.leetcode;

public class Demo538 {

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }

    // 反向中序遍历
    private void inOrder(TreeNode root) {
        if (null == root) {
            return;
        }

        inOrder(root.right);

        sum += root.val;

        root.val = sum;

//        if (null != root.right) {
//            root.val += root.right.val;
//        }
//        if (null != root.left) {
//            root.left.val += root.val;
//        }

        inOrder(root.left);


    }

}
