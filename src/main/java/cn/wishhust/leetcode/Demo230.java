package cn.wishhust.leetcode;
public class Demo230 {
    int count = 0;
    int val = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return val;
    }

    // 中序遍历
    private void inOrder(TreeNode root, int k) {
        if (null == root) {
            return;
        }
        inOrder(root.left, k);
        count++;
        if (count == k) {
            val = root.val;
        }
        inOrder(root.right, k);
    }

    public int kthSmallest2(TreeNode root, int k) {
        int count = count(root.left);
        if (count == k-1) {
            return root.val;
        } else if (count > k-1) {
            return kthSmallest2(root.left, k);
        } else {
            return kthSmallest2(root.right, k-count-1);
        }
    }


    // 求树节点个数
    private int count(TreeNode root) {
        if (null == root) {
            return 0;
        }

        return count(root.left) + count(root.right) + 1;
    }





}
