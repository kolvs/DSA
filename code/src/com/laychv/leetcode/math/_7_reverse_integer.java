package com.laychv.leetcode.math;

public class _7_reverse_integer {
    public static void main(String[] args) {
        String line = "123";
        int x = Integer.parseInt(line);

        int ret = new _7_reverse_integer().reverse(x);
        String out = String.valueOf(ret);
        System.out.println(out);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE / 10);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE / 10);
    }

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
