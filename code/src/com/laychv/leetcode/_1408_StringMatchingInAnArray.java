package com.laychv.leetcode;

import java.util.ArrayList;
import java.util.List;

import static com.laychv.common.PrintIntegerArray.stringListToString;

/**
 * 1408. 数组中的字符串匹配 🟢
 * <p>
 * 输入：words = ["mass","as","hero","superhero"]
 * 输出：["as","hero"]
 * 解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
 * ["hero","as"] 也是有效的答案。
 * <p>
 * 输入：words = ["leetcode","et","code"]
 * 输出：["et","code"]
 * 解释："et" 和 "code" 都是 "leetcode" 的子字符串。
 * <p>
 * https://leetcode.cn/problems/string-matching-in-an-array
 */
class _1408_StringMatchingInAnArray {

    public static void main(String[] args) {
        String[] words = {"mass", "as", "hero", "superhero"};
        System.out.print(stringListToString(stringMatching(words)));
    }

    public static List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j && words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}