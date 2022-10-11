package com.laychv.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等 🟢
 * <p>
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 * <p>
 * 输入：s1 = "bank", s2 = "kanb"
 * 输出：true
 * 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
 * <p>
 * 输入：s1 = "attack", s2 = "defend"
 * 输出：false
 * 解释：一次字符串交换无法使两个字符串相等
 * <p>
 * 输入：s1 = "kelb", s2 = "kelb"
 * 输出：true
 * 解释：两个字符串已经相等，所以不需要进行字符串交换
 * <p>
 * 输入：s1 = "abcd", s2 = "dcba"
 * 输出：false
 * <p>
 * https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal
 */
public class _1790_CheckIfOneStringSwapCanMakeStringsEqual {

    public static void main(String[] args) {
        String x = "bank";
        String y = "kanb";
        System.out.println(areAlmostEqual(x, y));
        String a = "abcd";
        String b = "dcba";
        System.out.println(areAlmostEqual2(a, b));
    }

    /**
     * 计数
     */
    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;

        String a = "";
        String b = "";

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                a += s1.charAt(i);
                b = s2.charAt(i) + b;
                if (a.length() > 2) return false;
            }
        }
        return (a.length() == 2) && (a.equals(b));
    }

    /**
     * 计数
     */
    public static boolean areAlmostEqual2(String s1, String s2) {
        // 存放index
        List<Integer> idx = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (idx.size() >= 2) return false;
                idx.add(i);
            }
        }
        if (idx.isEmpty()) return true;
        if (idx.size() != 2) return false;
        return s1.charAt(idx.get(0)) == s2.charAt(idx.get(1)) && s1.charAt(idx.get(1)) == s2.charAt(idx.get(0));
    }
}
