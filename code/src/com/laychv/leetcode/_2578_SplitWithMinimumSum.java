package com.laychv.leetcode;

import java.util.Arrays;

/**
 * 2578. 最小和分割 🟢
 * <p>
 * https://leetcode.cn/problems/split-with-minimum-sum/description/?envType=daily-question&envId=2023-10-09
 */
public class _2578_SplitWithMinimumSum {

    public static void main(String[] args) {
        System.out.println(splitNum(4325));
        System.out.println(splitNum(687));
    }

    // 贪心
    public static int splitNum(int num) {
        // 先转成string
        char[] str = Integer.toString(num).toCharArray();
        // 排序
        Arrays.sort(str);

        int n1 = 0, n2 = 0;

        for (int i = 0; i < str.length; i++) {
            if (i % 2 == 0) {
                n1 = n1 * 10 + (str[i] - '0');
            } else {
                n2 = n2 * 10 + (str[i] - '0');
            }
        }
        return n1 + n2;
    }

}
