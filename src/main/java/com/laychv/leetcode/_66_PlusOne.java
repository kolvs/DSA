package com.laychv.leetcode;

import java.util.Arrays;

/**
 * 数组-66. 加一 🟢
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * https://leetcode.cn/problems/plus-one/description/
 */
public class _66_PlusOne {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(Arrays.toString(plusOne(a)));
        int[] b = {4, 3, 2, 1};
        System.out.println(Arrays.toString(plusOne2(b)));
        int[] c = {9};
        System.out.println(Arrays.toString(plusOne2(c)));
    }

    /**
     * 需要考虑要不要进位问题：
     * 需要进位：9 + 1，99 + 1，999 + 1 ...
     * 不需要进位：1~8 + 1 (非0开始)
     * https://leetcode.cn/problems/plus-one/solutions/751837/jian-dan-yi-dong-javacpythonjs-pei-yang-lf0sg/
     */
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        // 倒序遍历
        for (int i = n - 1; i >= 0; i--) {
            // + 1 最右边元素 + 1
            digits[i] += 1;
            // 进制问题,表示需求向左进一位
            if (digits[i] == 10) {
                digits[i] = 0;
            } else {
                // 不进位直接返回digits
                return digits;
            }
        }
        // 存放首位
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }

    public static int[] plusOne2(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}