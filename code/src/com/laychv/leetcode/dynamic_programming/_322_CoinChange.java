package com.laychv.leetcode.dynamic_programming;

import static com.laychv.common.PrintIntegerArray.stringToIntegerArray;

/**
 * 322. 零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class _322_CoinChange {

    public static void main(String[] args) {
        String line = "";
        int[] coins = stringToIntegerArray(line);
        int amount = Integer.parseInt(line);
        int ret = new _322_CoinChange().coinChange(coins, amount);
        String out = String.valueOf(ret);
        System.out.print(out);
    }

    /**
     * 动态规划
     * 步骤
     * 1. 定义状态
     * 2. 状态转移方程
     */
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

    public int coinChange2(int[] coins, int amount) {
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