package com.laychv.leetcode;

/**
 * 14. 最长公共前缀 🟢
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * 提示：
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * <p>
 * https://leetcode.cn/problems/longest-common-prefix/
 */
public class _14_LongestCommonPrefix {

    public static void main(String[] args) {
        String[] x = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(x));
    }

    /**
     * 纵向扫描
     * f l o w e r
     * f l o w
     * f l i g h t
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        int ln = strs[0].length();
        int cnt = strs.length;

        for (int i = 0; i < ln; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < cnt; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

}
