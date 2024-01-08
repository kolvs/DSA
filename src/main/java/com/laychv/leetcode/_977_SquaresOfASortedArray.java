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

    static int[] sortedSquares2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];//
        }
        Arrays.sort(nums);//
        return nums;
    }

    static int[] sortedSquares3(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = nums[i] * nums[i];
        }
        Arrays.sort(res);
        return res;
    }

    static int[] sortedSquares4(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int k = nums.length - 1;//
        int[] res = new int[nums.length];

        while (l <= r) {//
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                res[k--] = nums[l] * nums[l++];//
            } else {
                res[k--] = nums[r] * nums[r--];//
            }
        }

        return res;
    }

    static int[] sortedSquares5(int[] nums) {
        int[] res = new int[nums.length];
        int k = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                res[k--] = nums[i] * nums[i++];
            } else {
                res[k--] = nums[j] * nums[j--];
            }
        }
        return res;
    }

}
