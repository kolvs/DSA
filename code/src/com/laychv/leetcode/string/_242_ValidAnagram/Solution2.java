package com.laychv.leetcode.string._242_ValidAnagram;

import java.util.HashMap;

/**
 * 哈希
 */
public class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            final char c = t.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) - 1);
            if (hashMap.get(c) < 0) {
                return false;
            }
        }
        return true;
    }
}
