package cn.wishhust.leetcode;
public class Demo121 {
    public static int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int max = 0;
        int minPrices = prices[0]; //第i天卖出，前i-1天第最小价格

        for (int i = 1; i < prices.length; i++) {
            max= Math.max(prices[i]-minPrices,max);

            minPrices = Math.min(minPrices,prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int [] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
