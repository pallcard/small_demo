package cn.wishhust.leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. 二叉树的层平均值
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 *
 * 示例 1:
 *
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 注意：
 *
 * 节点值的范围在32位有符号整数范围内。
 *
 */
public class Demo637 {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> list = new ArrayList<>();
        if (null == root) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 获得当前层 节点数量
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                sum += t.val;
                if (null != t.left) {
                    queue.add(t.left);
                }
                if (null != t.right) {
                    queue.add(t.right);
                }
            }
            list.add(sum/size);
        }
        return list;
    }
}
