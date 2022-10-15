package com.laychv.leetcode;

import java.util.Arrays;

/**
 * 1464. 数组中两元素的最大乘积 🟢
 * <p>
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 * 请你计算并返回该式的最大值。
 * <p>
 * 输入：nums = [3,4,5,2]
 * 输出：12
 * 解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
 * <p>
 * 输入：nums = [1,5,4,5]
 * 输出：16
 * 解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
 * <p>
 * 输入：nums = [3,7]
 * 输出：12
 * <p>
 * https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array
 */
public class _1464_MaximumProductOfTwoElementsInAnArray {

    public static void main(String[] args) {
        int[] x = {3, 4, 5, 2};
        System.out.println(maxProduct(x));
        int[] y = {1, 5, 4, 5};
        System.out.println(maxProduct2(y));
    }

    /**
     * sort array
     */
    static int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    /**
     *
     */
    static int maxProduct2(int[] nums) {
        int a = -1, b = -1;
        for (int n : nums) {
            if (n > a) {
                b = a;
                a = n;
            } else if (n > b) {
                b = n;
            }
        }
        return (a - 1) * (b - 1);
    }
}
