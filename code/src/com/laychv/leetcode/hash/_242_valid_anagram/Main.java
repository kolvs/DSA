package com.laychv.leetcode.hash._242_valid_anagram;

public class Main {
    public static void main(String[] args) {
        String s = "cart";
        String t = "catr";
        // array
        final boolean array = new Solution().isAnagram(s, t);
        System.out.println(array);
        // hash
        final boolean hash = new Solution2().isAnagram(s, t);
        System.out.println(hash);
    }
}
