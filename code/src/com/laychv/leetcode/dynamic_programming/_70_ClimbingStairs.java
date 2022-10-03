package com.laychv.leetcode.dynamic_programming;

/**
 * [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>
 * 递归
 * 包含重复计算
 * 可能导致内存溢出
 * <p>
 * 时间复杂度: O(n²)
 * 空间复杂度: O(n)
 */
class _70_ClimbingStairs {
    public static void main(String[] args) {
        String line = "";
        int n = Integer.parseInt(line);
        int ret = new _70_ClimbingStairs().climbStairs(n);
        String out = String.valueOf(ret);
        System.out.print(out);
    }

    public int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 记忆化递归
     * 避免重复计算
     * 核心: 开辟一个数组,存放已经计算过的值
     * <p>
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public int climbStairs2(int n) {
        // 避免重复计算,开辟一个数组,存放已经计算过的
        int[] mem = new int[n + 1];
        return memory(mem, n);
    }

    public int memory(int[] mem, int n) {
        // 计算过的,直接保存
        if (mem[n] > 0) {
            return mem[n];
        }
        if (n == 1) {
            mem[n] = 1;
        } else if (n == 2) {
            mem[n] = 2;
        } else {
            mem[n] = memory(mem, n - 1) + memory(mem, n - 2);
        }
        return mem[n];
    }


    /**
     * 动态规划
     * 注意： 循环
     * 时间复杂度： O(n)
     * 空间复杂度： O(n)
     */
    public int climbStairs3(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs4(int n) {
        if (n == 0 || n == 1 || n == 2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    /**
     * 公式法
     * <p>
     * Fn = 1 / 5 [(1+ √5 / 2)^n - (1 - √5 / 2)^n]
     *
     * 时间复杂度：O(logn)
     */
    public int climbStairs5(int n) {
        double sqrt5 = Math.sqrt(5);
        double fib = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) (fib / sqrt5);
    }
}