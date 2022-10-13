package com.laychv.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 856. 括号的分数 🟡
 * <p>
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 * <p>
 * 输入： "()"
 * 输出： 1
 * <p>
 * 输入： "(())"
 * 输出： 2
 * <p>
 * 输入： "()()"
 * 输出： 2
 * <p>
 * 输入： "(()(()))"
 * 输出： 6
 * <p>
 * https://leetcode.cn/problems/score-of-parentheses/
 */
public class _856_ScoreOfParentheses {

    public static void main(String[] args) {
        String x = "(()(()))";
        System.out.println(scoreOfParentheses(x));
        System.out.println(scoreOfParentheses2(x));
        System.out.println(scoreOfParentheses3(x));
        System.out.println(scoreOfParentheses4(x));
    }

    /**
     * 计数 最优解
     * TC:O(n)
     * SC:O(1)
     */
    public static int scoreOfParentheses(String s) {
        int res = 0;
        // 深度
        int dep = 0;

        for (int i = 0; i < s.length(); i++) {
            dep += (s.charAt(i) == '(' ? 1 : -1);
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                res += 1 << dep;// ???
            }
        }
        return res;
    }

    /**
     * stack Stack
     * 使用栈记录平衡字符串的分数，在开始之前要压入分数0，表示空字符串的分数。
     * Time Complexity：O(n)，其中 n 是字符串的长度。
     * Space Complexity：O(n)。栈需要 O(n) 的空间。
     */
    public static int scoreOfParentheses2(String s) {
        // 栈中存放的是分数
        Stack<Integer> stack = new Stack<>();
        // 从0开始放
        stack.push(0);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);
            } else {
                int top = stack.pop() + Math.max(2 * stack.pop(), 1);
                stack.push(top);
            }
        }

        return stack.peek();
    }

    /**
     * stack Deque
     * TC:O(n)
     * SC:O(n)
     */
    public static int scoreOfParentheses3(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.addLast(0);
            } else {
                int t = stack.pollLast();
                int p = stack.pollLast() + Math.max(2 * t, 1);
                stack.addLast(p);
            }
        }

        return stack.peekLast();
    }

    /**
     * 分治
     * TC:O(n²)
     * SC:O(n²)
     */
    public static int scoreOfParentheses4(String s) {
        if (s.length() == 2) return 1;

        int bal = 0, n = s.length(), len = 0;
        for (int i = 0; i < n; i++) {
            bal += (s.charAt(i) == '(' ? 1 : -1);
            if (bal == 0) {
                len = i + 1;
                break;
            }
        }
        if (len == n) {
            return 2 * scoreOfParentheses4(s.substring(1, n - 1));
        } else {
            return scoreOfParentheses4(s.substring(0, len)) + scoreOfParentheses4(s.substring(len));
        }
    }
}
