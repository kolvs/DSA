package com.laychv.leetcode;

/**
 * 7. 整数反转 🟠
 * <p>
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 输入：x = 123
 * 输出：321
 * <p>
 * 输入：x = -123
 * 输出：-321
 * <p>
 * 输入：x = 120
 * 输出：21
 * <p>
 * https://leetcode.cn/problems/reverse-integer
 */
public class _7_ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(123456789));
    }

    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            // 取值范围 -2^31 <  x < 2^31 -1
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            // 返回结果
            res = res * 10 + x % 10;
            // 分解原值
            x /= 10;
        }
        return res;
    }
}