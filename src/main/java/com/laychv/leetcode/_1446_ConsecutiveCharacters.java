package com.laychv.leetcode;

/**
 * 1446. 连续字符 🟢
 *
 * 给你一个字符串s，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 * <p>
 * 请你返回字符串的能量。
 * <p>
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 * <p>
 * 输入：s = "abbcccddddeeeeedcba"
 * 输出：5
 * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 * <p>
 * 输入：s = "triplepillooooow"
 * 输出：5
 * 示例 4：
 * <p>
 * 输入：s = "hooraaaaaaaaaaay"
 * 输出：11
 * <p>
 * 输入：s = "tourist"
 * 输出：1
 * <p>
 * https://leetcode.cn/problems/consecutive-characters
 */
public class _1446_ConsecutiveCharacters {

    public static void main(String[] args) {
        String x = "leetcode";
        System.out.print(maxPower(x));
    }

    public static int maxPower(String s) {
        int ans = 1, cnt = 1;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                ++cnt;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 1;
            }
        }
        return ans;
    }
}
