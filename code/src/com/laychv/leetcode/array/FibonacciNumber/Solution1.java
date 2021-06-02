package com.laychv.leetcode.array.FibonacciNumber;

/**
 * 递归
 *
 * 时间复杂度: o(2^n)
 * 空间复杂度: O(1)
 */
class Solution1 {
    public int fib(int N) {
        if(N <= 1){
            return N;
        }
        return fib(N -1) + fib(N -2);
    }
}