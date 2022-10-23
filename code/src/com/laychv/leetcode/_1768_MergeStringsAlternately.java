package com.laychv.leetcode;

/**
 * 1768. 交替合并字符串 🟢
 * <p>
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。
 * 如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * 返回 合并后的字符串 。
 * <p>
 * 输入：word1 = "abc", word2 = "pqr"
 * 输出："apbqcr"
 * 解释：字符串合并情况如下所示：
 * word1：  a   b   c
 * word2：    p   q   r
 * 合并后：  a p b q c r
 * <p>
 * 输入：word1 = "ab", word2 = "pqrs"
 * 输出："apbqrs"
 * 解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
 * word1：  a   b
 * word2：    p   q   r   s
 * 合并后：  a p b q   r   s
 * <p>
 * 输入：word1 = "abcd", word2 = "pq"
 * 输出："apbqcd"
 * 解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
 * word1：  a   b   c   d
 * word2：    p   q
 * 合并后：  a p b q c   d
 * <p>
 * 提示：
 * 1 <= word1.length, word2.length <= 100
 * word1 和 word2 由小写英文字母组成
 * <p>
 * https://leetcode.cn/problems/merge-strings-alternately
 */
public class _1768_MergeStringsAlternately {

    public static void main(String[] args) {
        System.out.println("apbqcr->:" + mergeAlternately("abc", "pqr"));
        System.out.println("apbqrs->:" + mergeAlternately("ab", "pqrs"));
        System.out.println("apbqcd->:" + mergeAlternately("abcd", "pq"));
    }

    /**
     * 双指针 + StringBuilder
     * 我们使用两个指针 i 和 j，初始时分别指向两个字符串的首个位置。
     * 随后的每次循环中，依次进行如下的两步操作：
     * 如果 i 没有超出 word1 的范围，就将 word1[i] 加入答案，并且将 i 移动一个位置；
     * 如果 j 没有超出 word2 的范围，就将 word2[j] 加入答案，并且将 j 移动一个位置。
     * 当 i 和 j 都超出对应的范围后，结束循环并返回答案即可。
     */
    public static String mergeAlternately(String word1, String word2) {
        int w1 = word1.length();
        int w2 = word2.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0, j = 0; i < w1 || j < w2; i++, j++) {
            if (i < w1) {
                sb.append(word1.charAt(i));
            }
            if (j < w2) {
                sb.append(word2.charAt(j));
            }
        }
        return sb.toString();
    }

    /**
     * 双指针 + char
     */
    public String mergeAlternately2(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int idx = 0;

        char[] res = new char[l1 + l2];

        for (int i = 0; i < l1 || i < l2; i++) {
            if (i < l1) {
                res[idx++] = word1.charAt(i);
            }
            if (i < l2) {
                res[idx++] = word2.charAt(i);
            }
        }

        return new String(res);
    }
}
