package com.laychv.leetcode;

/**
 * 367. 有效的完全平方数 🟢
 * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
 * 不能使用任何内置的库函数，如  sqrt 。
 * <p>
 * 输入：num = 16
 * 输出：true
 * 解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
 * <p>
 * 输入：num = 14
 * 输出：false
 * 解释：返回 false ，因为 3.742 * 3.742 = 14 但 3.742 不是一个整数。
 * <p>
 * 提示：
 * 1 <= num <= 231 - 1
 * https://leetcode.cn/problems/valid-perfect-square/
 */
public class _367_ValidPerfectSquare {

    /*** robust ***/
    static boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int res;
        for (int i = 1; i < num; i++) {
            res = i * i;
            if (res == num) return true;
        }
        return false;
    }

    /**
     * brute force
     */
    static boolean isPerfectSquare2(int num) {
        for (long i = 0; i * i <= num; i++) {
            if (i == num) return true;
        }
        return false;
    }

    /**
     * binary search
     * 因为num是正整数，所以若正整数x满足x×x=num，则x一定满足1≤x≤num。
     */
    static boolean isPerfectSquare3(int num) {
        int left = 0;
        int right = num;
        // [left,right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;//
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * binary search
     * [left,right)
     */
    static boolean isPerfectSquare4(int num) {
        long l = 0, r = num;
        while (l < r) {
            long m = l + r + 1 >> 1;
            if (m * m <= num) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return r * r == num;
    }

}
