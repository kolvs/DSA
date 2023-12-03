package com.laychv.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 816. 模糊坐标 🟠
 * <p>
 * 我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
 * 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
 * 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
 * <p>
 * 输入: "(123)"
 * 输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * <p>
 * 输入: "(00011)"
 * 输出:  ["(0.001, 1)", "(0, 0.011)"]
 * 解释:0.0, 00, 0001 或 00.01 是不被允许的。
 * <p>
 * 输入: "(0123)"
 * 输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 * <p>
 * 输入: "(100)"
 * 输出: [(10, 0)]
 * 解释:1.0 是不被允许的。
 * <p>
 * 提示:
 * 4 <= S.length <= 12.
 * S[0] = "(", S[S.length - 1] = ")", 且字符串 S 中的其他元素都是数字。
 * <p>
 * https://leetcode.cn/problems/ambiguous-coordinates/description/
 */
public class _816AmbiguousCoordinates {

    public static void main(String[] args) {
        System.out.println("[(0, 123), (0, 12.3), (0, 1.23), (0.1, 23), (0.1, 2.3), (0.12, 3)]");
        System.out.println(ambiguousCoordinates("(0123)"));
    }

    public static List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        s = s.substring(1, s.length() - 1); // 先去掉前后括号，只保留数字部分。即："(034)"——>"034"
        for (int i = 1; i < s.length(); i++) // 将s划分成【x轴】和【y轴】
            for (String x : getNums(s.substring(0, i))) // 获得x轴，然后使用“小数点”分割出【n种】可能的合法数字
                for (String y : getNums(s.substring(i))) // 获得y轴，然后使用“小数点”分割出【m种】可能的合法数字
                    result.add(new StringBuilder("(").append(x).append(", ").append(y).append(")").toString()); // 拼装在最终结果【n*m种】
        return result;
    }

    private static List<String> getNums(String num) {
        List<String> list = new ArrayList<>();
        int i = 1;
        String left, right;
        while (i <= num.length()) {
            left = num.substring(0, i); // 分割【整数】部分
            right = num.substring(i++); // 分割【小数】部分
            if ((!left.equals("0") && left.charAt(0) == '0') || // 对于逗号左侧【整数】，不允许以0开头，除非这个整数就是0本身
                    (!right.isEmpty() && right.charAt(right.length() - 1) == '0')) continue; // 对于逗号右侧【小数】，不允许以0作为结尾
            if (right.isEmpty()) list.add(left);
            else list.add(new StringBuilder(left).append(".").append(right).toString());
        }
        return list;
    }
}
