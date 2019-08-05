package cn.wishhust.leetcode;

/**
 *
 * 若 a<b<c<d, d-a = (d-c) + (c-b) + (b-a)
 *
 */

public class Demo122 {

    public int maxProfit(int[] prices) {

        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                result += (prices[i] - prices[i-1]);
            }
        }
        return result;
    }
}
