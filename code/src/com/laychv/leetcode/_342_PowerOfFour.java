package com.laychv.leetcode;

/**
 * 342. 4的幂 🟢
 * <p>
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * <p>
 * 输入：n = 16
 * 输出：true
 * <p>
 * 输入：n = 5
 * 输出：false
 * <p>
 * 输入：n = 1
 * 输出：true
 * <p>
 * 提示：-2^31 <= n <= 2^31 - 1
 * <p>
 * https://leetcode.cn/problems/power-of-four
 */
public class _342_PowerOfFour {

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(5));
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour2(16));
    }

    /**
     * 亦或 ^
     * 如果 nn 是 44 的幂，那么它可以表示成 4^x4^x
     * 的形式，我们可以发现它除以 33 的余数一定为 11，即：
     * 4^x≡(3+1)^x ≡ 1^x ≡ 1 (% 3)
     * 如果 n 是 2 的幂却不是 4 的幂，那么它可以表示成 4^x 2的形式，
     * 此时它除以 3 的余数一定为 2。
     * 因此我们可以通过 nn 除以 3 的余数是否为 1 来判断 n 是否是 4 的幂。
     */
    public static boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }

    /**
     * 二进制表示中 1 的位置
     */
    public static boolean isPowerOfFour2(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }
}
