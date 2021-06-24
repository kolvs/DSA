package com.laychv.leetcode.math._9_palindrome_number;

public class Solution {
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