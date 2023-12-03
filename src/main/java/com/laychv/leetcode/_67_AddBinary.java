package com.laychv.leetcode;

/**
 * 数组-67. 二进制求和 🟢
 * <p>
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * <p>
 * 输入:a = "11", b = "1"
 * 输出："100"
 * 示例 2：
 * <p>
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 * <p>
 * 提示：
 * 1 <= a.length, b.length <= 104
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 * https://leetcode.cn/problems/add-binary/
 */
public class _67_AddBinary {

    public static void main(String[] args) {
        String a = "1010", b = "1011";
        String c = "11", d = "1";
        System.out.println(addBinary(a, b));
        System.out.println(addBinary(c, d));
    }

    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int val = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = val;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            res.append(sum % 2);
            val = sum / 2;
        }
        res.append(val == 1 ? val : "");
        return res.reverse().toString();
    }

}
