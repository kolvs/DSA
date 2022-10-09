package com.laychv.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串 🟡
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * <p>
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String x = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(x));
        System.out.println(lengthOfLongestSubstring2(x));
    }

    // map
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int res = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            res = Math.max(res, i - left + 1);
        }

        return res;
    }

    // set
    // https://leetcode.cn/problems/longest-substring-without-repeating-characters/solution/dong-hua-yan-shi-3-wu-zhong-fu-zi-fu-de-q7u6c/
    public static int lengthOfLongestSubstring2(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();

        // 定义滑动窗口左右边界 右边界初始值为-1，表示刚开始窗口还不存在
        int left = 0;
        int right = -1;
        while (left < s.length()) {
            // 如果还有元素可考察，且当前考察元素在set中不存在
            // 同时将当前考察元素存入set，同时扩大窗口右边界
            if (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            } else {
                // 当前考察元素在set中有，则需要缩小窗口左边界
                // 在缩小左边界时，要将对应元素从set移除
                set.remove(s.charAt(left));
                left++;
            }
            // 计算子串最大长度
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
