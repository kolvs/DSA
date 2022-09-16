package com.laychv.leetcode.dynamic_programming._70_ClimbingStairs;

/**
 * 动态规划
 * 注意： 循环
 * 时间复杂度： O(n)
 * 空间复杂度： O(n)
 */
class Solution3 {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs2(int n) {
        if (n == 0 || n == 1 || n == 2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}