package main.java.cn.wishhust.leetcode;

public class Demo746 {
    public static int minCostClimbingStairs(int[] cost) {

        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i-1],cost[i-2]);
        }

        return Math.min(cost[cost.length-2],cost[cost.length-1]);

    }

    public static void main(String[] args) {
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
