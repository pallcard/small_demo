package cn.wishhust.leetcode;
public class Demo236 {

    public static boolean isChildNode(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        } else if (root == p) {
            return true;
        }
        return isChildNode(root.left, p) || isChildNode(root.right, p);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (( isChildNode(root.left, p) && isChildNode(root.right, q))
                || (isChildNode(root.left, q) && isChildNode(root.right, p))
                ||  root == q
                || root == p
            ) {
            return root;
        } else if(isChildNode(root.left,p) && isChildNode(root.left,q)) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }

    }


    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {//当遍历到叶结点后就会返回null
            return root;
        }
        if (root == p || root == q) {//当找到p或者q的是时候就会返回pq
            return root;/*当然，值得一提的是，如果公共祖先是自己（pq），并不需要寻找另外
                     一个，我们在执行前序遍历会先找上面的，后找下面的，我们会直接返回公共祖先。*/
        }
        TreeNode left = LowestCommonAncestor(root.left, p, q);//返回的结点进行保存，可能是null
        TreeNode right = LowestCommonAncestor(root.right, p, q);//也可能是pq，还可能是公共祖先
        if (left != null && right != null) {
            return root;//如果左右都存在，就说明pq都出现了，这就是，公共祖先，此时不用考虑公共祖先是自己的情况，因为上面已经做过判断了。
        } else if (left != null) {//否则我们返回已经找到的那个值（存储在left，与right中），p或者q
            return left;//还有一种可能就是，由下面返回的公共祖先，并将这个值一路返回到最表层
        } else if (right != null) {
            return right;
        }
        return null;
    }


    // 方法三
    TreeNode result;
    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (null == currentNode) {
            return false;
        }

        int left = recurseTree(currentNode.left, p, q) ? 1 : 0;
        int right = recurseTree(currentNode.right, p, q) ? 1 : 0;

        int mid = 0;
        if (currentNode == p || currentNode == q) {
            mid = 1;
        }

        if (left+right+mid>=2) {
            result = currentNode;
        }

        return (left+right+mid)>0;
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return result;
    }
}
