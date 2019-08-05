package cn.wishhust.leetcode;
public class Demo437 {

//    private int count = 0;
//
//    public int pathSum(TreeNode root, int sum) {
//        if (null == root) {
//            return 0;
//        }
//        if (sum == 0) {
//            count++;
//        }
//
//        count += pathSum(root.left, sum-root.val);
//        count += pathSum(root.right, sum-root.val);
//
//        count = pathSum(root.left, sum) + pathSum(root.right, sum) + count;
//        return count;
//    }

    public int pathSum(TreeNode root, int sum) {
        if (null == root) {
            return 0;
        }

        int count = 0;
        count += pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return count;

    }

    public int pathSumStartWithRoot(TreeNode root, int sum) {
        if (null == root) {
            return 0;
        }
        int count = 0;
        if (sum == root.val) {
            count++;
        }
        count += pathSumStartWithRoot(root.left, sum-root.val) + pathSumStartWithRoot(root.right, sum-root.val);
        return count;
    }

}
