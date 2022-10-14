package com.laychv.leetcode;

import java.util.Arrays;

/**
 * 940. 不同的子序列 II 🔴
 * <p>
 * 给定一个字符串 s，计算 s 的 不同非空子序列 的个数。因为结果可能很大，所以返回答案需要对 10^9 + 7 取余 。
 * 字符串的 子序列 是经由原字符串删除一些（也可能不删除）字符但不改变剩余字符相对位置的一个新字符串。
 * 例如，"ace" 是 "abcde" 的一个子序列，但 "aec" 不是。
 * <p>
 * 输入：s = "abc"
 * 输出：7
 * 解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
 * <p>
 * 输入：s = "aba"
 * 输出：6
 * 解释：6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。
 * <p>
 * 输入：s = "aaa"
 * 输出：3
 * 解释：3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。
 * <p>
 * https://leetcode.cn/problems/distinct-subsequences-ii
 */
public class _940_DistinctSubsequences_II {

    public static void main(String[] args) {
        String x = "abc";
        String y = "zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn";
        System.out.println(distinctSubseqII(x));
        System.out.println(distinctSubseqII2(y));
        System.out.println(distinctSubseqII3(y));
        System.out.println(distinctSubseqII4(y));
    }

    /**
     * 动态规划
     * https://leetcode.cn/problems/distinct-subsequences-ii/solution/zhua-wa-mou-si-tu-jie-leetcode-by-muse-7-j2sy/
     */
    public static int distinctSubseqII(String s) {
        int mod = (int) (1e9 + 7);
        long res = 0;
        // 记录26个字符每个字符的子序列总数
        long[] sum = new long[26];

        for (char c : s.toCharArray()) {
            // 获得字符c前一次统计的子序列数
            long i = sum[c - 'a'];
            // 计算当前字符c的子序列数
            sum[c - 'a'] = (res + 1) % mod;
            // 加mod的目的是为了防止结果溢出为负数
            res = (res + sum[c - 'a'] - i + mod) % mod;
        }

        return (int) res;
    }

    /**
     * 动态规划 1
     * 时间复杂度：O(n∣Σ∣)，其中 n 是字符串 s 的长度，Σ 是字符集，在本题中 ∣Σ∣=26。即为动态规划需要的时间。
     * 空间复杂度：O(n+∣Σ∣)。即为数组 f 和 last 需要的空间。
     */
    public static int distinctSubseqII2(String s) {
        int mod = (int) (1e9 + 7);
        int[] sum = new int[26];
        Arrays.fill(sum, -1);
        int n = s.length();
        int[] f = new int[n];
        Arrays.fill(f, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                if (sum[j] != -1) {
                    f[i] = (f[i] + f[sum[j]]) % mod;
                }
            }
            sum[s.charAt(i) - 'a'] = i;
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (sum[i] != -1) {
                res = (res + f[sum[i]]) % mod;
            }
        }

        return res;
    }

    /**
     * 优化动态规划1
     * 动态规划2
     * 时间复杂度：O(n∣Σ∣)，其中 n 是字符串 s 的长度，\Σ 是字符集，在本题中 ∣Σ∣=26。即为动态规划需要的时间。
     * 空间复杂度：O(∣Σ∣)。即为数组 g 和 last 需要的空间。
     */
    public static int distinctSubseqII3(String s) {
        int mod = (int) (1e9 + 7);
        int[] g = new int[26];
        int n = s.length();
        int res = 0;

        for (int i = 0; i < n; i++) {
            int total = 1;
            for (int j = 0; j < 26; j++) {
                total = (total + g[j]) % mod;
            }
            g[s.charAt(i) - 'a'] = total;
        }

        for (int i = 0; i < 26; i++) {
            res = (res + g[i]) % mod;
        }
        return res;
    }

    /**
     * 优化动态规划2
     * 动态规划 3
     */
    public static int distinctSubseqII4(String s) {
        int mod = (int) (1e9 + 7);
        int[] g = new int[26];
        int n = s.length(), total = 0;

        for (int i = 0; i < n; i++) {
            int oi = s.charAt(i) - 'a';
            int pre = g[oi];
            g[oi] = (total + 1) % mod;
            total = ((total + g[oi] - pre) % mod + mod) % mod;
        }

        return total;
    }
}
