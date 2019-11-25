package cn.wishhust.leetcode;


/**
 *
 * 230. 二叉搜索树中第K小的元素
 *
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 *
 */

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
