package com.laychv.leetcode;

import java.util.Arrays;

/**
 * 1668. 最大重复子字符串 🟢
 * <p>
 * 给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为 k 。
 * 单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 为 0 。
 * 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。
 * <p>
 * 输入：sequence = "ababc", word = "ab"
 * 输出：2
 * 解释："abab" 是 "ababc" 的子字符串。
 * <p>
 * 输入：sequence = "ababc", word = "ba"
 * 输出：1
 * 解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
 * <p>
 * 输入：sequence = "ababc", word = "ac"
 * 输出：0
 * 解释："ac" 不是 "ababc" 的子字符串。
 * <p>
 * 提示：
 * 1 <= sequence.length <= 100
 * 1 <= word.length <= 100
 * sequence 和 word 都只包含小写英文字母。
 * <p>
 * https://leetcode.cn/problems/maximum-repeating-substring/
 */
public class _1668_MaximumRepeatingSubstring {

    public static void main(String[] args) {
        System.out.println("2->:" + maxRepeating("ababc", "ab"));
        System.out.println("2->:" + maxRepeating2("ababc", "ab"));
    }

    /**
     * 枚举 + 动态规划
     * ------⎧ f[i−∣word∣]+1, valid[i] = 1 ∧ i ≥ ∣word∣
     * f[i]= ⎨ 1,             valid[i] = 1 ∧ i < ∣word∣
     * ------⎩ 0,             otherwise
     * https://leetcode.cn/problems/maximum-repeating-substring/solutions/1943410/zui-da-zhong-fu-zi-zi-fu-chuan-by-leetco-r4cp/
     */
    public static int maxRepeating(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();
        if (n < m) return 0;

        int[] f = new int[n];
        for (int i = m - 1; i < n; i++) {
            boolean valid = true;
            for (int j = 0; j < m; j++) {
                if (sequence.charAt(i - m + j + 1) != word.charAt(j)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                f[i] = (i == m - 1 ? 0 : f[i - m]) + 1;
            }
        }

        return Arrays.stream(f).max().getAsInt();
    }

    /**
     * 序列 DP
     * https://leetcode.cn/problems/maximum-repeating-substring/solutions/1945358/by-ac_oier-xjhn/
     */
    public static int maxRepeating2(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();
        int res = 0;
        if (n < m) return 0;

        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i - m < 0) continue;
            if (sequence.substring(i - m, i).equals(word)) {
                f[i] = f[i - m] + 1;
            }
            res = Math.max(res, f[i]);
        }

        return res;
    }

}
