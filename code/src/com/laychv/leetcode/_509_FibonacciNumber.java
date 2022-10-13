package com.laychv.leetcode;

/**
 * 509. 斐波那契数 🟢
 * 斐波那契数，通常用F(n) 表示，形成的序列称为斐波那契数列。该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定N，计算F(N)。
 * <p>
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * <p>
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 * <p>
 * 提示：0 ≤ N ≤ 30
 * <p>
 * https://leetcode.cn/problems/fibonacci-number
 */

class _509_FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(fib(3));
        System.out.println(fib2(3));
    }

    /**
     * 递归
     * <p>
     * 时间复杂度: o(2^n)
     * 空间复杂度: O(1)
     */
    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 动态规划
     * <p>
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public static int fib2(int n) {
        // 终止条件
        if (n <= 1) return n;
        // 定义状态
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        // 状态转移方程
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}