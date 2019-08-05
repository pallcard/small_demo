package cn.wishhust.leetcode;
public class Demo226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;



//        TreeNode left = root.left;
//        root.left = invertTree(root.right);
//        root.right = invertTree(left);
//        return root;
    }
}
