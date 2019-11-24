package cn.wishhust.leetcode;

/**
 *
 * 101. �Գƶ�����
 * ����һ����������������Ƿ��Ǿ���ԳƵġ�
 *
 * ���磬������?[1,2,2,3,4,4,3] �ǶԳƵġ�
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * �����������?[1,2,2,null,3,null,3] ���Ǿ���ԳƵ�:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * ˵��:
 *
 * �����������õݹ�͵������ַ������������⣬��ܼӷ֡�
 *
 */

public class Demo101 {
    public boolean isSymmetric(TreeNode root) {

        if (null == root) {
            return true;
        }

        return isSymmetric(root.left,root.right);
    }


    public boolean isSymmetric(TreeNode s, TreeNode t) {
        if (null == s && null == t) {
            return true;
        }
        if (null == s || null == t) {
            return false;
        }

        if (s.val == t.val) {
            return isSymmetric(s.left, t.right) && isSymmetric(s.right, t.left);
        } else {
            return false;
        }
    }


}
