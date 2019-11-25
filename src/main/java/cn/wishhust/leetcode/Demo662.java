package cn.wishhust.leetcode;
import java.util.LinkedList;
import java.util.Queue;

public class Demo662 {

    public int widthOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> indexTree = new LinkedList<>();
        int max = 1;
        queue.add(root);
        indexTree.add(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                int index = indexTree.removeFirst();
                if (null != top.left) {
                    queue.add(top.left);
                    indexTree.add(index*2);
                }
                if (null != top.right) {
                    queue.add(top.right);
                    indexTree.add(index*2+1);
                }
            }
            if (indexTree.size() >= 2) {
                max = Math.max(max, indexTree.getLast()-indexTree.getFirst()+1);
            }
        }
        return max;

    }


}
