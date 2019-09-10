package cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [1,3,2]
 *
 * 中序遍历：左 根 右
 * 将左子树进栈，
 */
public class Demo094 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(null == root) {
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        if (null == root) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//
//        while (!stack.isEmpty()) {
//            TreeNode cur = stack.peek();
//            while (null != cur.left) {
//                stack.push(cur.left);
//                cur = cur.left;
//            }
//            cur = stack.pop();
//            list.add(cur.val);
//            if (null != cur.right) {
//                stack.push(cur.right);
//            }
//        }

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            // 一直往左子树走
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}
