package com.laychv.leetcode;

import java.util.HashMap;
import java.util.Map;

import static com.laychv.common.PrintListNode.stringToIntegerArray;

/**
 * 137. 只出现一次的数字 II 🟠
 * <p>
 * 给你一个整数数组nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法且不使用额外空间来解决此问题。
 * <p>
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * <p>
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 * <p>
 * https://leetcode.cn/problems/single-number-ii/
 * <p>
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
