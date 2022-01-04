package com.laychv.leetcode.array._509_FibonacciNumber;

/**
 * 动态规划
 * <p>
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
public class Solution2 {
    public int fib(int N) {
        // 终止条件
        if (N <= 1) {
            return N;
        }
        // 定义状态
        int[] dp = new int[N + 1];
        dp[1] = dp[2] = 1;
        // 状态转移方程
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }
}