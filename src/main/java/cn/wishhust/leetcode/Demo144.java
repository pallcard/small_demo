package cn.wishhust.leetcode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 *
 */

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
