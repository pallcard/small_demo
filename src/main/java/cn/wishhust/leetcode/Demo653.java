package cn.wishhust.leetcode;
import java.util.ArrayList;
import java.util.List;

/**
 * 653. 两数之和 IV - 输入 BST
 *
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *  
 *
 * 案例 2:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 *
 *
 */

public class Demo653 {
    public boolean findTarget(TreeNode root, int k) {
        inOrder(root);
        int i = 0;
        int j = list.size()-1;
        while (i < j) {
            if (list.get(i) + list.get(j)>k) {
                j--;
            } else if(list.get(i) + list.get(j)<k) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
    List<Integer> list = new ArrayList<>();
    private void inOrder(TreeNode root) {
        if (null == root) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

}
