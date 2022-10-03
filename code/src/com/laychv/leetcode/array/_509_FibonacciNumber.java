package com.laychv.leetcode.array;

/**
 * 509. 斐波那契数
 * 斐波那契数，通常用F(n) 表示，形成的序列称为斐波那契数列。该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定N，计算F(N)。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 示例 3：
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 * <p>
 * 提示：
 * <p>
 * 0 ≤ N ≤ 30
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class _509_FibonacciNumber {
    /**
     * 递归
     * <p>
     * 时间复杂度: o(2^n)
     * 空间复杂度: O(1)
     */
    public static void main(String[] args) {
        String line = "";
        int N = Integer.parseInt(line);
        int ret = new _509_FibonacciNumber().fib(N);
        String out = String.valueOf(ret);
        System.out.print(out);
    }

    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        return fib(N - 1) + fib(N - 2);
    }

    /**
     * 动态规划
     * <p>
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public int fib2(int N) {
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