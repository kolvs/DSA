package com.laychv.leetcode;

import static com.laychv.common.PrintIntegerArray.stringToStringArray;

/**
 * 1662. 检查两个字符串数组是否相等 🟢
 * <p>
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 * 数组表示的字符串是由数组中的所有元素 按顺序 连接形成的字符串。
 * <p>
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 true
 * <p>
 * 输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
 * 输出：false
 * <p>
 * 输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * 输出：true
 * <p>
 * 提示：
 * 1 <= word1.length, word2.length <= 10^3
 * 1 <= word1[i].length, word2[i].length <= 10^3
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 10^3
 * word1[i] 和 word2[i] 由小写字母组成
 * <p>
 * https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent
 */
public class _1662_CheckIfTwoStringArraysAreEquivalent {

    public static void main(String[] args) {
        System.out.println("false->:" + arrayStringsAreEqual(stringToStringArray("[\"a\", \"cb\"]"), stringToStringArray("[\"a\", \"bc\"]")));
        System.out.println("true->:" + arrayStringsAreEqual(stringToStringArray("[\"abc\", \"d\", \"defg\"]"), stringToStringArray("[\"abcddefg\"]")));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return join(word1).equals(join(word2));
    }

    private static String join(String[] word) {
        StringBuilder sb = new StringBuilder();
        for (String s : word) {
            sb.append(s);
        }
        return sb.toString();
    }
}
