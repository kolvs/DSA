package com.laychv.leetcode;

import static com.laychv.common.PrintListNode.stringToIntegerArray;

/**
 * 136. 只出现一次的数字 🟢
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 * https://leetcode.cn/problems/single-number/
 * <p>
 * 136,137,260
 */
public class _136_SingleNumber {

    public static void main(String[] args) {
        String x = "[2,2,1]";
        System.out.print(singleNumber(stringToIntegerArray(x)));
    }

    static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
