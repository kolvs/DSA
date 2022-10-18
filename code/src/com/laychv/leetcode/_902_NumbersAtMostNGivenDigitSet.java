package com.laychv.leetcode;

/**
 * 902. 最大为 N 的数字组合 🔴
 * <p>
 * 给定一个按非递减顺序排列的数字数组digits。你可以用任意次数digits[i]来写的数字。
 * 例如，如果digits = ['1','3','5']，我们可以写数字，如'13','551', 和'1351315'。
 * 返回 可以生成的小于或等于给定整数 n 的正整数的个数。
 * <p>
 * 输入：digits = ["1","3","5","7"], n = 100
 * 输出：20
 * 解释：
 * 可写出的 20 个数字是：
 * 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
 * <p>
 * 输入：digits = ["1","4","9"], n = 1000000000
 * 输出：29523
 * 解释：
 * 我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
 * 81 个四位数字，243 个五位数字，729 个六位数字，
 * 2187 个七位数字，6561 个八位数字和 19683 个九位数字。
 * 总共，可以使用D中的数字写出 29523 个整数。
 * <p>
 * 输入：digits = ["7"], n = 8
 * 输出：1
 * <p>
 * 提示：
 * 1 <= digits.length <= 9
 * digits[i].length == 1
 * digits[i]是从'1'到'9' 的数
 * digits中的所有值都 不同
 * digits按非递减顺序排列
 * 1 <= n <= 10^9
 * <p>
 * https://leetcode.cn/problems/numbers-at-most-n-given-digit-set/
 */
public class _902_NumbersAtMostNGivenDigitSet {

    public static void main(String[] args) {
        String[] x = {"1", "3", "5", "7"};
        String[] y = {"1", "4", "9"};
        System.out.println(atMostNGivenDigitSet(x, 100));
        System.out.println(atMostNGivenDigitSet2(y, 1000000000));
    }

    /**
     * 数位 动态规划
     */
    public static int atMostNGivenDigitSet(String[] digits, int n) {
        String s = Integer.toString(n);
        int m = digits.length, k = s.length();
        int[][] dp = new int[k + 1][2];
        dp[0][1] = 1;
        for (int i = 1; i <= k; i++) {
            for (String digit : digits) {
                if (digit.charAt(0) == s.charAt(i - 1)) {
                    dp[i][1] = dp[i - 1][1];
                } else if (digit.charAt(0) < s.charAt(i - 1)) {
                    dp[i][0] += dp[i - 1][1];
                } else {
                    break;
                }
            }
            if (i > 1) {
                dp[i][0] += m + dp[i - 1][0] * m;
            }
        }
        return dp[k][0] + dp[k][1];
    }

    /**
     * 数学
     */
    public static int atMostNGivenDigitSet2(String[] digits, int n) {
        char[] nc = String.valueOf(n).toCharArray();
        int res = 0, ncl = nc.length, dl = digits.length;

        // 先对【非最高位】的其他位，可组装的数字进行统计
        for (int i = 1; i < ncl; i++) {
            res += Math.pow(dl, i);
        }

        for (int i = 0; i < ncl; i++) {
            // 是否需要对比下一个数字
            boolean compareNext = false;
            for (String digit : digits) {
                char dc = digit.charAt(0); // 将String转换为char
                if (dc < nc[i]) {
                    res += Math.pow(dl, ncl - i - 1);
                } else {
                    if (dc == nc[i]) compareNext = true;
                    break;
                }
            }
            if (!compareNext) return res;
        }

        return res;
    }
}
