package com.laychv.leetcode;

import java.util.Arrays;

/**
 * 977. 有序数组的平方 🟢
 * <p>
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * https://leetcode.cn/problems/squares-of-a-sorted-array/
 */
public class _977_SquaresOfASortedArray {

    public static void main(String[] args) {
        int[] x = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(x)));
        int[] y = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares(y)));
    }

    static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0, j = nums.length - 1, k = nums.length - 1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                res[k] = nums[i] * nums[i];
                i++;
            } else {
                res[k] = nums[j] * nums[j];
                j--;
            }
            k--;
        }
        return res;
    }

}
