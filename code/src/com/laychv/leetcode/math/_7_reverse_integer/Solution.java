package com.laychv.leetcode.math._7_reverse_integer;

public class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            // 取值范围 -2^31 <  x < 2^31 -1
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            // 返回结果
            result = result * 10 + x % 10;
            // 分解原值
            x /= 10;
        }
        return result;
    }
}
