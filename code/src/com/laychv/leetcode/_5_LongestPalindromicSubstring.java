package com.laychv.leetcode;

/**
 * 5. 最长回文子串 🟡
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * https://leetcode.cn/problems/longest-palindromic-substring/
 */
public class _5_LongestPalindromicSubstring {

    public static void main(String[] args) {
        String x = "babad";
        System.out.println(longestPalindrome(x));
        String y = "cbbd";
        System.out.println(longestPalindrome2(y));
    }

    /**
     * 中心扩散-双指针
     */
    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = fun(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = fun(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    private static String fun(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }

    /**
     * 动态规划
     */
    public static String longestPalindrome2(String s) {
        int length = s.length();
        int maxS = 0;
        int maxE = 0;
        int maxL = 1;

        boolean[][] dp = new boolean[length][length];

        for (int r = 1; r < length; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxL) {
                        maxL = r - l + 1;
                        maxS = l;
                        maxE = r;
                    }
                }
            }
        }
        return s.substring(maxS, maxE + 1);
    }
}
