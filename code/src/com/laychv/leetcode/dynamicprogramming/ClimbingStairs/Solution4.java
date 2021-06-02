package com.laychv.leetcode.dynamicprogramming.ClimbingStairs;

/**
 * 公式法
 * <p>
 * Fn = 1 / 5 [(1+ √5 / 2)^n - (1 - √5 / 2)^n]
 *
 * 时间复杂度：O(logn)
 */
class Solution4 {
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double fib = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) (fib / sqrt5);
    }
}