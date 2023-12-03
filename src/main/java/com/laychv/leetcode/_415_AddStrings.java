package com.laychv.leetcode;

/**
 * 415. 字符串相加 🟢
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * 示例 1：
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * <p>
 * https://leetcode.cn/problems/add-strings/description/
 */
public class _415_AddStrings {

    public static void main(String[] args) {
        System.out.println("134: " + addStrings("11", "123"));
        System.out.println("533: " + addStrings("456", "77"));
        System.out.println("134: " + addStrings2("11", "123"));
        System.out.println("533: " + addStrings2("456", "77"));

        System.out.println("100: " + subString("123", "13"));
    }

    /***模拟**/
    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;// 移动到末尾
        int add = 0;// 进位
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int res = x + y + add;
            ans.append(res % 10);
            add = res / 10;
            i--;
            j--;
        }
        return ans.reverse().toString();
    }

    /***双指针**/
    public static String addStrings2(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder ans = new StringBuilder();
        for (int c = 0; i >= 0 || j >= 0; i--, j--) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            c += x + y;
            ans.append(c % 10);
            c /= 10;
        }
        return ans.reverse().toString();
    }

    /***字符串减法**/
    public static String subString(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder ans = new StringBuilder();
        for (int c = 0; i >= 0 || j >= 0; i--, j--) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            ans.append((x - c - y + 10) % 10);
            c = x - c - y < 0 ? 1 : 0;
        }
        return ans.reverse().toString();
    }
}
