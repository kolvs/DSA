package com.laychv.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1106. 解析布尔表达式 🔴
 * <p>
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 * 有效的表达式需遵循以下约定：
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 * <p>
 * 输入：expression = "!(f)"
 * 输出：true
 * <p>
 * 输入：expression = "|(f,t)"
 * 输出：true
 * <p>
 * 输入：expression = "&(t,f)"
 * 输出：false
 * <p>
 * 输入：expression = "|(&(t,f,t),!(t))"
 * 输出：false
 * <p>
 * 提示：
 * 1 <= expression.length <= 20000
 * expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。
 * expression 是以上述形式给出的有效表达式，表示一个布尔值。
 * <p>
 * https://leetcode.cn/problems/parsing-a-boolean-expression/
 */
public class _1106_ParsingABooleanExpression {

    public static void main(String[] args) {
        System.out.println("false->:" + parseBoolExpr("|(&(t,f,t),!(t))"));
    }

    // double stack
    // https://leetcode.cn/problems/parsing-a-boolean-expression/solutions/1949498/by-ac_oier-jr29/
    public static boolean parseBoolExpr(String expression) {
        Deque<Character> nums = new ArrayDeque<>(), ops = new ArrayDeque<>();
        for (char c : expression.toCharArray()) {
            if (c == ',') continue;
            if (c == 't' || c == 'f') nums.addLast(c);
            if (c == '|' || c == '&' || c == '!') ops.addLast(c);
            if (c == '(') nums.addLast('-');
            if (c == ')') {
                char op = ops.pollLast(), cur = ' ';
                while (!nums.isEmpty() && nums.peekLast() != '-') {
                    char top = nums.pollLast();
                    cur = cur == ' ' ? top : calc(top, cur, op);
                }
                if (op == '!') cur = cur == 't' ? 'f' : 't';
                nums.pollLast();
                nums.addLast(cur);
            }
        }
        return nums.peekLast() == 't';
    }

    static char calc(char a, char b, char op) {
        boolean x = a == 't', y = b == 't';
        boolean ans = op == '|' ? x | y : x & y;
        return ans ? 't' : 'f';
    }
}
