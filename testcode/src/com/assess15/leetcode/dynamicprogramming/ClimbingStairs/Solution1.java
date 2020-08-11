package com.assess15.leetcode.dynamicprogramming.ClimbingStairs;

/**
 * 递归
 * 包含重复计算
 * 可能导致内存溢出
 *
 * 时间复杂度: O(n²)
 * 空间复杂度: O(n)
 */
class Solution1 {
    public int climbStairs(int n) {
        if (n <=2) return n;
        return climbStairs(n-1) + climbStairs(n-2);
    }
}