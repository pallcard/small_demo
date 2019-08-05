package cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Demo095 {
    public List<TreeNode> generateTrees(int n) {

        if (n == 0) {
            return new ArrayList<>();
        }

        return generateTree(1, n);

    }
    // 分治
    public static List<TreeNode> generateTree(int start, int end) {

        List<TreeNode> list = new ArrayList<>();
        //  根划分后，子树不存在时
        if (start > end) {
            list.add(null);
            return list;
        }


        for (int i = start; i <= end; i++) {
            // 以i为分割点，（start，i-1），（i+1，end），i为根
            List<TreeNode> left = generateTree(start,i-1);
            List<TreeNode> right = generateTree(i+1,end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    // i为根，将左右子树加在根的左右两边
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }

        }
        return list;
    }

}
