package com.laychv.leetcode;

/**
 * 779. 第K个语法符号 🟠
 * <p>
 * 我们构建了一个包含 n 行(索引从 1 开始)的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
 * 给定行数n和序数 k，返回第 n 行中第 k个字符。（k从索引 1 开始）
 * <p>
 * 输入: n = 1, k = 1
 * 输出: 0
 * 解释: 第一行：0
 * <p>
 * 输入: n = 2, k = 1
 * 输出: 0
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * <p>
 * 输入: n = 2, k = 2
 * 输出: 1
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * <p>
 * 提示:
 * 1 <= n <= 30
 * 1 <= k <= 2^n - 1
 * <p>
 * https://leetcode.cn/problems/k-th-symbol-in-grammar
 */
public class _779_KthSymbolInGrammar {

    public static void main(String[] args) {
        System.out.println("0->:" + kthGrammar(1, 1));
        System.out.println("1->:" + kthGrammar2(2, 2));
        System.out.println("1->:" + kthGrammar3(2, 2));
    }

    /**
     * 找规律 + 递归
     */
    public static int kthGrammar(int n, int k) {
        // 向上遍历到了第1行，则返回结果
        if (k == 1) return 0;
        if (k > (1 << (n - 2))) {
            return 1 ^ kthGrammar(n - 1, k - (1 << (n - 2)));
        }
        return kthGrammar(n - 1, k);
    }

    /**
     * 找规律 + 位运算
     */
    public static int kthGrammar2(int n, int k) {
        k--;
        int res = 0;
        while (k > 0) {
            k &= k - 1;
            res ^= 1;
        }
        return res;
    }

    /**
     * API 🎉
     */
    public static int kthGrammar3(int n, int k) {
        return Integer.bitCount(k - 1) & 1;
    }

}
