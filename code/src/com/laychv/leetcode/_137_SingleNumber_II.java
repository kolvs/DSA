package com.laychv.leetcode;

import java.util.HashMap;
import java.util.Map;

import static com.laychv.common.PrintSingleNode.stringToIntegerArray;

/**
 * 137. 只出现一次的数字 II
 * <p>
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * <p>
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 * <p>
 * https://leetcode.cn/problems/single-number-ii/
 * 136,137,260
 */
public class _137_SingleNumber_II {

    public static void main(String[] args) {
        String str = "[2,2,3,2]";
        System.out.print(singleNumber(stringToIntegerArray(str)));
    }

    // hash
    public static int singleNumber(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), occ = entry.getValue();
            if (occ == 1) {
                res = num;
                break;
            }
        }

        return res;
    }
}
