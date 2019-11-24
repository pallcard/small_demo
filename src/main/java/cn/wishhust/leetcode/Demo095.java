package cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 */

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

        // 1 2 3
        // 1--0 1 2--3 ;  1--1 2 3--3 ; 1--2 3 4--3
        //
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
