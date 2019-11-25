package cn.wishhust.test.guanglianda;

public class Question4 {
    public int maxProfit(int[] prices, int free) {

        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {

                if (prices[i] - prices[i-1] > free) {
                    result += (prices[i] - prices[i-1] - free);
                } else {
                    min = Math.min(min, prices[i-1]);
                }

            }
        }
        return result;
    }
}
