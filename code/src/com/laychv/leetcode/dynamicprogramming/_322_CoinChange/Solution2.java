package com.laychv.leetcode.dynamicprogramming._322_CoinChange;

/**
 * 动态规划
 */
class Solution2 {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        int[] mem = new int[amount + 1];
        mem[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && mem[i - coins[j]] < min) {
                    min = mem[i - coins[j]] + 1;
                }
            }
            mem[i] = min;
        }
        return mem[amount] == Integer.MAX_VALUE ? -1 : mem[amount];
    }
}