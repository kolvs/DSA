package com.laychv.leetcode;

/**
 * 1678. 设计 Goal 解析器 🟢
 * <p>
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。
 * Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。
 * 然后，按原顺序将经解释得到的字符串连接成一个字符串。
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 * <p>
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 * <p>
 * 输入：command = "G()()()()(al)"
 * 输出："Gooooal"
 * <p>
 * 输入：command = "(al)G(al)()()G"
 * 输出："alGalooG"
 * <p>
 * 提示：
 * 1 <= command.length <= 100
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成
 * <p>
 * https://leetcode.cn/problems/goal-parser-interpretation/description/
 */
public class _1678_GoalParserInterpretation {

    public static void main(String[] args) {
        System.out.println("Goal->:" + interpret("G()(al)"));
        System.out.println("Goal->:" + interpret2("G()(al)"));
        System.out.println("alGalooG->:" + interpret("(al)G(al)()()G"));
    }

    public static String interpret(String command) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                sb.append("G");
            } else if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    sb.append("o");
                } else {
                    sb.append("al");
                }
            }
        }

        return sb.toString();
    }

    /**
     * API 🎉
     */
    public static String interpret2(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }
}
