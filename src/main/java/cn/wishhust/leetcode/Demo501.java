package cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 */
public class Demo501 {

    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        inOrder(root);

        int [] arr = new int [list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
    int curCount = 1;
    int maxCount = 1;
    TreeNode pre = null;
    private void inOrder(TreeNode root) {
        if (null == root) {
            return;
        }
        inOrder(root.left);
        if (null != pre) {
            if (root.val == pre.val) {
                curCount++;
            } else {
                curCount =1;
            }
        }
        if (curCount > maxCount) {
            maxCount = curCount;
            list.clear();
            list.add(root.val);
        } else if (curCount == maxCount) {
            list.add(root.val);
        }

        pre = root;
        inOrder(root.right);

    }
}
