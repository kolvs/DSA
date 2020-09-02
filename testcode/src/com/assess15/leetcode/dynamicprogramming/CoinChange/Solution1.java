package com.assess15.leetcode.dynamicprogramming.CoinChange;

/**
 * 动态规划
 * 步骤
 * 1. 定义状态
 * 2. 状态转移方程
 */
class Solution1 {
    public int coinChange(int[] coins, int amount) {
        // 开辟空间
        int[] f = new int[amount + 1];
        int n = coins.length;
        // 初始化
        f[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; ++j) {
                if (i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i - coins[j]] + 1, f[i]);
                }
            }
        }
        if (f[amount] == Integer.MAX_VALUE) {
            f[amount] = -1;
        }
        return f[amount];
    }
}