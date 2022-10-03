package com.laychv.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;


/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 * <p>
 * 示例1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t仅包含小写字母
 * <p>
 * 进阶:如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _242_ValidAnagram {
    public static void main(String[] args) {
        String s = "cart";
        String t = "catr";
        // array
        final boolean array = new _242_ValidAnagram().isAnagram(s, t);
        System.out.println(array);
        // hash
        final boolean hash = new _242_ValidAnagram().isAnagram(s, t);
        System.out.println(hash);
    }

    /**
     * 排序,比较
     */
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

    public boolean isAnagram2(String s, String t) {
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
