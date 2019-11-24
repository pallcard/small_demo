package cn.wishhust.leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 *
 * 145. 二叉树的后序遍历
 *
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 *
 */


public class Demo145 {

    List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (null == root) {
            return list;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }


    // 先做（根右左） 再反转  ==> 左右根
    public List<Integer> postorderTraversal2(TreeNode root) {
        if (null == root) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            list.add(t.val);

            if (null != t.left) {
                stack.push(t.left);
            }

            if (null != t.right) {
                stack.push(t.right);
            }

        }
        Collections.reverse(list);
        return list;
    }


    // 左右根
    public List<Integer> postorderTraversal3(TreeNode root) {
        if (null == root) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);


        // pre 记录之前访问的节点
        TreeNode pre = null;
        while (!stack.isEmpty()) {

            TreeNode cur = stack.peek();

            // 当前访问节点无左右孩子，或者当前访问的节点的左、右孩子已经访问
            if ((null == cur.left && null == cur.right) || (null != pre && (cur.left == pre || cur.right == pre))) {
                list.add(cur.val);
                pre = cur;
                stack.pop();
            }
            else {
                if (null != cur.right) {
                    stack.push(cur.right);
                }

                if (null != cur.left) {
                    stack.push(cur.left);
                }
            }
        }
        return list;
    }

}
