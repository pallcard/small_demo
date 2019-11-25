package cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 257. 二叉树的所有路径
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 *
 *
 *
 */

public class Demo257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return Arrays.asList();
        } else {
            sb.append(root.val);
        }

        binaryTreePaths(root, sb, list);


        return list;

    }

    public static void binaryTreePaths(TreeNode root, StringBuilder sb, List<String> list) {
        if (root.right == null && root.left == null) {
            list.add(sb.toString());
            return;
        }

        if (root.left != null) {
            String part = "->" + root.left.val;
            sb.append(part);
            binaryTreePaths(root.left, sb, list);
            sb.delete(sb.length()-part.length(), sb.length());
        }

        if (root.right != null) {
            String part = "->" + root.right.val;
            sb.append(part);
            binaryTreePaths(root.right, sb, list);
            sb.delete(sb.length() - part.length(), sb.length());
        }

    }


}
