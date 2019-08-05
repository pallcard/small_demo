package cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;

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
