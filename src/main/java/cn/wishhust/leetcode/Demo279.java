package cn.wishhust.leetcode;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 279. 完全平方数
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 */

public class Demo279 {
    public static int numSquares(int n) {

        int [] dp = new int[n+1];

        for (int i = 2; i < n+1; i++) {
            dp[i] = n+1;
        }

        dp[1] = 1;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            for (int j = 2; j <=  n; j++) {
                if (j >= i*i) {
                    dp[j] = Math.min(dp[j],dp[j-i*i]+1);
                }
            }
        }
        return dp[n];
    }


    // 广度优先解法

    //    从n到0，每个数字代表一个节点;；
    //
    //    如果两个数 x 到 y 相差一个完全平方数，则连接一条边；
    //
    //    我们就得到了一个无权图；
    //
    //    原来的问题就转化为，在这个无权图中找出从 n 到 0 的最短路径，所以需要 BFS 来完成


    static class Node {
        int val;
        int step;

        public Node(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }

    // 将问题转化成图论
    // 该算法在往队列里面添加节点的时候会 add 很多重复的节点，导致超时，
    // 优化办法是，加入 visited 数组，检查要 add 的数据是否已经出现过了，防止数据重复出现，从而影响图的遍历
    // 同时优化：num - i * i 表达式，只让他计算一次
    // 同时在循环体里面判断退出或返回的条件，而不是在循环体外
    public static int numSquares2(int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 0));
        // 其实一个真正的图的 BSF 是一定会加上 visited 数组来过滤元素的
        boolean[] visited = new boolean[n+1];
        while (!queue.isEmpty()) {
            int num = queue.peek().val;
            int step = queue.peek().step;
            queue.remove();

            for (int i = 1; ; i++) {
                int a = num - i * i;
                if (a < 0) {
                    break;
                }
                // 若 a 已经计算到 0 了，就不必再往下执行了
                if (a == 0) {
                    return step + 1;
                }
                if (!visited[a]) {
                    queue.add(new Node(a, step + 1));
                    visited[a] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(4));
        System.out.println(numSquares2(12));
    }
}


