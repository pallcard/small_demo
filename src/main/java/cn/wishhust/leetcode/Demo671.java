package cn.wishhust.leetcode;

/**
 * 671. 二叉树中第二小的节点
 *
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 * 示例 2:
 *
 * 输入:
 *     2
 *    / \
 *   2   2
 *
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 *
 *
 */

public class Demo671 {
    int min = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;
    int flag = 2;
    public int findSecondMinimumValue(TreeNode root) {
        if (null == root) {
            return -1;
        }
        if (root.val < min) {
            flag--;
            min2 = min;
            min = root.val;
        } else if (root.val <= min2 && root.val != min) {
            flag--;
            min2 = root.val;
        }
        findSecondMinimumValue(root.left);
        findSecondMinimumValue(root.right);
        return flag>0?-1:min2;
    }

}
