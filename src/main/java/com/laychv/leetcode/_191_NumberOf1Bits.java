package com.laychv.leetcode;

/**
 * 191. 位1的个数 🟢
 * <p>
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * 提示：
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。
 * 在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，
 * 因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的示例 3中，输入表示有符号整数 -3。
 * <p>
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。
 * <p>
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000中，共有一位为 '1'。
 * <p>
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 * <p>
 * 提示：输入必须是长度为 32 的 二进制串 。
 * <p>
 * 进阶：如果多次调用这个函数，你将如何优化你的算法？
 * <p>
 * https://leetcode.cn/problems/number-of-1-bits
 */
public class _191_NumberOf1Bits {

    public static void main(String[] args) {
        System.out.println("3->:" + hammingWeight(00000000000000000000000000001011));
        System.out.println("1->:" + hammingWeight2(00000000000000000000000010000000));
        System.out.println("1->:" + hammingWeight3(00000000000000000000000010000000));
//        System.out.println(hammingWeight(11111111111111111111111111111101));
    }

    public static int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

    /**
     * 位运算优化
     * n & (n - 1) 很实用用来消除二进制中最后一位1
     */
    public static int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            // n & (n - 1) ： n 的二进制表示:消除数字最后一个 1
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    /**
     * API 🎉
     */
    public static int hammingWeight3(int n) {
        return Integer.bitCount(n);
    }
}
