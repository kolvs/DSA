package com.laychv.leetcode;

import static com.laychv.common.PrintIntegerArray.integerArrayToString;

/**
 * 167. 两数之和 II - 输入有序数组 🟡
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * <p>
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
 * <p>
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 * 解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * <p>
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted
 */
public class _167_TwoSum_II_InputArrayIsSorted {

    public static void main(String[] args) {
        int[] x = {2, 7, 11, 15};
        int xt = 9;
        System.out.println(integerArrayToString(twoSum(x, xt)));
    }

    /**
     * 双指针
     */
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int k = numbers[i] + numbers[j];
            if (k == target) {
                return new int[]{i + 1, j + 1};
            } else if (k < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{};
    }
}
