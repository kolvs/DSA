package com.laychv.leetcode.dynamic_programming._70_ClimbingStairs;

/**
 * 记忆化递归
 * 避免重复计算
 * 核心: 开辟一个数组,存放已经计算过的值
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
class Solution2 {
    public int climbStairs(int n) {
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
}