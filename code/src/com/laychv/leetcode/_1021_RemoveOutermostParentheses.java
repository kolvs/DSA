package com.laychv.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1021. 删除最外层的括号 🟢
 * <p>
 * 有效括号字符串为空 ""、"(" + A + ")"或A + B ，其中A 和B都是有效的括号字符串，+代表字符串的连接。
 * 例如，""，"()"，"(())()"和"(()(()))"都是有效的括号字符串。
 * 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B的方法，我们称其为原语（primitive），其中A 和B都是非空有效括号字符串。
 * 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中P_i是有效括号字符串原语。
 * 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。
 * <p>
 * 输入：s = "(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * <p>
 * 输入：s = "(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * <p>
 * 输入：s = "()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 * <p>
 * https://leetcode.cn/problems/remove-outermost-parentheses
 */
public class _1021_RemoveOutermostParentheses {
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }

    // stack
    public static String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int length = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans.append(c);
            }
            if (c == '(') {
                stack.push(c);
            }
        }
        return ans.toString();
    }
}
