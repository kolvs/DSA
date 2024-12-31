package com.laychv.leetcode;

class _122_BestTimeToBuyAndSellStock_II {

    public static void main(String[] args) {
        int[] x = {2, 7, 11, 15};
        System.out.println(maxProfit(x));
    }

    /**
     * 一次遍历
     */
    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += (prices[i] - prices[i - 1]);
            }
        }
        return res;
    }

}