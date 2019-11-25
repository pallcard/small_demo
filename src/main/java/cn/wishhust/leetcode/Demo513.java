package cn.wishhust.leetcode;
import java.util.LinkedList;
import java.util.Queue;

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
