package com.laychv.leetcode;

/**
 * 151. 翻转字符串里的单词
 */
public class _151_ReverseWords {
    public static void main(String[] args) {
        String s1 = "the sky is blue";
        System.out.println(reverseWords(s1));
    }

    public static String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i].equals("")) continue;
            res.append(str[i] + " ");
        }
        return res.toString().trim();
    }
}