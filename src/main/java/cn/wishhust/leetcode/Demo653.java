package cn.wishhust.leetcode;
import java.util.ArrayList;
import java.util.List;

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
