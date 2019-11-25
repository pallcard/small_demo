package cn.wishhust.leetcode;
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
