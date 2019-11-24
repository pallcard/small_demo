package cn.wishhust.leetcode;

/**
 *
 * 235. �����������������������
 *
 *����һ������������, �ҵ�����������ָ���ڵ������������ȡ�
 *
 * �ٶȰٿ�������������ȵĶ���Ϊ���������и��� T ��������� p��q������������ȱ�ʾΪһ����� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
 *
 * ���磬�������¶���������:? root =?[6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 * ?
 *
 * ʾ�� 1:
 *
 * ����: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * ���: 6
 * ����: �ڵ� 2 �ͽڵ� 8 ��������������� 6��
 * ʾ�� 2:
 *
 * ����: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * ���: 2
 * ����: �ڵ� 2 �ͽڵ� 4 ��������������� 2, ��Ϊ���ݶ�������������Ƚڵ����Ϊ�ڵ㱾��
 * ?
 *
 * ˵��:
 *
 * ���нڵ��ֵ����Ψһ�ġ�
 * p��q Ϊ��ͬ�ڵ��Ҿ������ڸ����Ķ����������С�
 *
 */
public class Demo235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode t = p;
            p = q;
            q = t;
        }
        if (p.val <= root.val && root.val <= q.val) {
            return root;
        } else if(p.val < root.val && root.val > q.val) {
            return lowestCommonAncestor(root.left,p,q);
        } else {
            return lowestCommonAncestor(root.right,p,q);
        }
    }
}

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) {val = x;}
//}
