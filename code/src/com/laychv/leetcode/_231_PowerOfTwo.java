package com.laychv.leetcode;

/**
 * 231. 2 的幂 🟢
 * <p>
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得n == 2x ，则认为 n 是 2 的幂次方。
 * <p>
 * 输入：n = 1
 * 输出：true
 * 解释：2^0 = 1
 * <p>
 * 输入：n = 16
 * 输出：true
 * 解释：2^4 = 16
 * <p>
 * 输入：n = 3
 * 输出：false
 * <p>
 * 输入：n = 4
 * 输出：true
 * <p>
 * 输入：n = 5
 * 输出：false
 * <p>
 * 提示：-2^31 <= n <= 2^31 - 1
 * <p>
 * https://leetcode.cn/problems/power-of-two
 */
public class _231_PowerOfTwo {

    public static void main(String[] args) {
        System.out.println("true->:" + isPowerOfTwo(1));
        System.out.println("true->:" + isPowerOfTwo(16));
        System.out.println("false->:" + isPowerOfTwo(3));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}
