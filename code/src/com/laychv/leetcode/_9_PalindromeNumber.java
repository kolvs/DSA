package com.laychv.leetcode;

import static com.laychv.common.PrintSingleNode.booleanToString;

/**
 * 9. 回文数 🟢
 * <p>
 * 输入：x = 121
 * 输出：true
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * https://leetcode.cn/problems/palindrome-number/
 */
public class _9_PalindromeNumber {

    public static void main(String[] args) {
        int x = 121;
        System.out.println(booleanToString(isPalindrome(x)));
    }

    public static boolean isPalindrome(int x) {
        // 取值边界:[]
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int result = 0;
        while (x > result) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return x == result / 10 || x == result;
    }
}