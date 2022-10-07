package com.laychv.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.laychv.common.PrintSingleNode.stringToIntegerArray;

/**
 * 260. 只出现一次的数字 III
 * <p>
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * <p>
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * <p>
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * <p>
 * https://leetcode.cn/problems/single-number-iii/
 */
public class _260_SingleNumber_III {

    public static void main(String[] args) {
        String x = "[1,2,1,3,2,5]";
        System.out.print(Arrays.toString(singleNumber(stringToIntegerArray(x))));
    }

    public static int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] res = new int[2];

        for (int n : nums) {
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        }

        int i = 0;
        for (Integer n : set) {
            res[i] = n;
            i++;
        }

        return res;
    }
}
