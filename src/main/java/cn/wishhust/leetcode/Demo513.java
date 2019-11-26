package cn.wishhust.leetcode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 *
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *  
 *
 * 示例 2:
 *
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 *  
 *
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 *
 *
 */
public class Demo513 {
    public int findBottomLeftValue(TreeNode root) {
        // 给定树不为空
//        if(null == root) {
//            return
//        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int reslut = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                if (i == 0) {
                    reslut = t.val;
                }
                if (null != t.left) {
                    queue.add(t.left);
                }
                if (null != t.right) {
                    queue.add(t.right);
                }
            }
        }
        return reslut;
    }
}
