package com.laychv.leetcode.stack.Valid_Parentheses;

import java.util.HashMap;
import java.util.Stack;

class Solution {

    HashMap<Character, Character> map;

    public Solution() {
        map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                char top = stack.isEmpty() ? '#' : stack.pop();
                if (top != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}