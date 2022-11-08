package com.laychv.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1684. 统计一致字符串的数目 🟢
 * <p>
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。
 * 如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 * 请你返回 words 数组中 一致字符串 的数目。
 * <p>
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 * <p>
 * 输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * 输出：7
 * 解释：所有字符串都是一致的。
 * <p>
 * 输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * 输出：4
 * 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 * <p>
 * 提示：
 * 1 <= words.length <= 10^4
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * allowed 中的字符 互不相同 。
 * words[i] 和 allowed 只包含小写英文字母。
 * <p>
 * https://leetcode.cn/problems/count-the-number-of-consistent-strings/description/
 */
public class _1684_CountTheNumberOfConsistent {

    public static void main(String[] args) {
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};
        System.out.println("2->:" + countConsistentStrings("ab", words));
        System.out.println("2->:" + countConsistentStrings2("ab", words));
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        boolean[] s = new boolean[26];
        for (char c : allowed.toCharArray()) {
            s[c - 'a'] = true;
        }
        int res = 0;
        for (String w : words) {
            if (check(w, s)) {
                ++res;
            }
        }
        return res;
    }

    private static boolean check(String w, boolean[] s) {
        for (int i = 0; i < w.length(); i++) {
            if (!s[w.charAt(i) - 'a']) {
                return false;
            }
        }
        return true;
    }

    private static int countConsistentStrings2(String allowed, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        int count = words.length;

        //将allowed中的字符存入map中
        for (int i = 0; i < allowed.length(); i++) {
            map.put(allowed.charAt(i), 1);
        }

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                //如果map中找不到，则说明不存在，不符合条件
                if (!map.containsKey(word.charAt(i))) {
                    count--;
                    break;
                }
            }
        }

        return count;
    }

}
