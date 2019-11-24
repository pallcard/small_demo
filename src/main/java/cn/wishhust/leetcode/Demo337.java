package cn.wishhust.leetcode;

/**
 *
 * 337. 打家劫舍 III
 *
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 *
 *
 */

public class Demo337 {

    //可以把根节点看作一个很特殊的节点。因为打劫直接相连的房子会引发报警，所以当打劫了根节点后，便不能打劫左右的子节点。那么，就可以把问题简化成打劫根节点与不打劫根节点中求最大值的问题。


    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 不包含根节点
        int exclusive = rob(root.left) + rob(root.right);

        // 包含根节点
        int include = root.val;
        if (null != root.left) {
            include += rob(root.left.left)+rob(root.left.right);
        }
        if (null != root.right) {
            include += rob(root.right.left)+rob(root.right.right);
        }

        return Math.max(exclusive,include);
    }
}
