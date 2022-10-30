package com.laychv.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 784. 字母大小写全排列 🟠
 * <p>
 * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 * <p>
 * 输入：s = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入: s = "3z4"
 * 输出: ["3z4","3Z4"]
 * <p>
 * 提示:
 * 1 <= s.length <= 12
 * s 由小写英文字母、大写英文字母和数字组成
 * <p>
 * https://leetcode.cn/problems/letter-case-permutation/
 */
public class _784_LetterCasePermutation {

    public static void main(String[] args) {
        System.out.println("[a1b2, a1B2, A1b2, A1B2]->:");
        System.out.println(letterCasePermutation("a1b2"));
        System.out.println(letterCasePermutation2("a1b2"));
    }

    /**
     * dfs 回溯
     */
    public static List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        char[] cs = s.toCharArray();
        dfs(cs, 0, res);
        return res;
    }

    private static void dfs(char[] cs, int i, List<String> res) {
        if (cs.length == i) {
            res.add(new String(cs));
            return;
        }
        dfs(cs, i + 1, res);
        if (Character.isLetter(cs[i])) {
            cs[i] ^= 1 << 5;
            dfs(cs, i + 1, res);
        }
    }

    /**
     * bfs
     */
    public static List<String> letterCasePermutation2(String s) {
        List<String> res = new ArrayList<>();

        Queue<StringBuilder> queue = new ArrayDeque<>();
        queue.add(new StringBuilder());

        while (!queue.isEmpty()) {
            StringBuilder curr = queue.peek();
            if (curr.length() == s.length()) {
                res.add(curr.toString());
                queue.poll();
            } else {
                int pos = curr.length();
                if (Character.isLetter(s.charAt(pos))) {
                    StringBuilder next = new StringBuilder(curr);
                    next.append((char) (s.charAt(pos) ^ 32));
                    queue.offer(next);
                }
                curr.append(s.charAt(pos));
            }
        }

        return res;
    }

}
