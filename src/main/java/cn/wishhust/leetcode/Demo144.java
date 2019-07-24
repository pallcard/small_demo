package main.java.cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Demo144 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;

    }
    // 非递归实现先序遍历
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            list.add(t.val);
            if (null != t.right) {
                stack.add(t.right);
            }
            if (null != t.left) {
                stack.add(t.left);
            }
        }
        return list;
    }

}
