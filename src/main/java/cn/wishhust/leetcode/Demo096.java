package cn.wishhust.leetcode;

public class Demo096 {
    // f(n) = f(0) * f(n-1) + f(1)*f(n-2) + ...+ f(n-1)*f(0)
    // 左子树0个节点，右子树n-1个节点
    // 左子树1个节点，右子树n-2个节点
    // 。。。
    public int numTrees(int n) {

        if (n==0 || n==1) {
            return 1;
        }

        int [] nums = new int[n+1];

        nums[0] = 1;
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i] += nums[j]*nums[n-j-1];
            }
        }

        return nums[n];
    }



}
