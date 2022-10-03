package com.laychv.leetcode.math;

import static com.laychv.common.PrintSingleNode.booleanToString;

public class _9_palindrome_number {

    public static void main(String[] args) {
        String line = "";
        int x = Integer.parseInt(line);
        boolean ret = new _9_palindrome_number().isPalindrome(x);
        String out = booleanToString(ret);
        System.out.print(out);
    }

    public boolean isPalindrome(int x) {
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