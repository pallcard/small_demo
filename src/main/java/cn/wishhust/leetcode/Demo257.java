package main.java.cn.wishhust.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
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
