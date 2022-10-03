package com.laychv.leetcode.stack;

import java.util.HashMap;
import java.util.Stack;

import static com.laychv.common.PrintSingleNode.booleanToString;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class _20_ValidParentheses {
    HashMap<Character, Character> map;

    public _20_ValidParentheses() {
        map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');
    }

    public static void main(String[] args) {
        String s = "()[()]";
        boolean ret = new _20_ValidParentheses().isValid(s);
        String out = booleanToString(ret);
        System.out.print(out);
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