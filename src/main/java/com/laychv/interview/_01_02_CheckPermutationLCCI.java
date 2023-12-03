package com.laychv.interview;

import java.util.Arrays;

/**
 * 面试题 01.02. 判定是否互为字符重排 🟢
 * <p>
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * <p>
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * <p>
 * 说明：
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 * <p>
 * https://leetcode.cn/problems/check-permutation-lcci/
 */
public class _01_02_CheckPermutationLCCI {

    public static void main(String[] args) {
        String a = "abc";
        String b = "bca";
        System.out.println(CheckPermutation(a, b));
        System.out.println(CheckPermutation2(a, b));
    }

    public static boolean CheckPermutation(String s1, String s2) {
        // 判断条件
        if (s1.length() != s2.length()) return false;
        // 排序
        // 1.转成 char 数组
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        // 2.对char数组排序
        Arrays.sort(c1);
        Arrays.sort(c2);
        // 判断char数组中元素是否相等
        return Arrays.equals(c1, c2);
    }

    public static boolean CheckPermutation2(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int sum = 0;
        // 判断条件
        if (n != m) return false;
        //
        int[] res = new int[256];
        for (int i = 0; i < n; i++) {
            if (++res[s1.charAt(i)] == 1) sum++;
            if (--res[s2.charAt(i)] == 0) sum--;
        }
        return sum == 0;
    }
}
