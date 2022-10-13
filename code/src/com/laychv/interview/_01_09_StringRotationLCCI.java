package com.laychv.interview;

/**
 * 面试题 01.09. 字符串轮转 🟢
 * <p>
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 * <p>
 * 输入：s1 = "waterbottle", s2 = "erbottlewat"
 * 输出：True
 * <p>
 * 输入：s1 = "aa", s2 = "aba"
 * 输出：False
 * <p>
 * 提示：字符串长度在[0, 100000]范围内。
 * 说明:你能只调用一次检查子串的方法吗？
 * <p>
 * https://leetcode.cn/problems/string-rotation-lcci/
 */
public class _01_09_StringRotationLCCI {

    public static void main(String[] args) {
        String x = "waterbottle";
        String y = "erbottlewat";
        System.out.println(isFlipedString(x, y));
    }

    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
}
