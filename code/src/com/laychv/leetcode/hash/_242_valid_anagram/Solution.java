package com.laychv.leetcode.hash._242_valid_anagram;

import java.util.Arrays;

/**
 * 排序,比较
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        final char[] s1 = s.toCharArray();
        final char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1, t1);
    }
}
