package com.laychv.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号 🟢
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
 * <p>
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * https://leetcode.cn/problems/valid-parentheses
 */

class _20_ValidParentheses {

    public static void main(String[] args) {
        String s = "()[()]";
        System.out.print(isValid(s));
    }

    public static boolean isValid(String s) {
        int n = s.length();
        if ((n & 1) == 1) return false;

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || map.get(c) != stack.peek()) return false;
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}