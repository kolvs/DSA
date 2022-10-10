package com.laychv.leetcode;

import static com.laychv.common.PrintIntegerArray.stringToIntegerArray;

/**
 * 322. 零钱兑换
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * <p>
 * https://leetcode.cn/problems/coin-change
 */

class _322_CoinChange {

    public static void main(String[] args) {
        String x = "[1, 2, 5]";
        int amount = 11;
        System.out.println(coinChange(stringToIntegerArray(x), amount));
        System.out.println(coinChange2(stringToIntegerArray(x), amount));
    }

    /**
     * 动态规划
     * 步骤
     * 1. 定义状态
     * 2. 状态转移方程
     */
    public static int coinChange(int[] coins, int amount) {
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

    public static int coinChange2(int[] coins, int amount) {
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