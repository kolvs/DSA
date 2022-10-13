package com.laychv.leetcode;

import static com.laychv.common.PrintIntegerArray.stringToIntegerArray;

/**
 * 1800. 最大升序子数组和 🟢
 * <p>
 * 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 * <p>
 * 子数组是数组中的一个连续数字序列。
 * <p>
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 若对所有 i（l <= i < r），numsi < numsi+1 都成立，
 * 则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
 * <p>
 * 输入：nums = [10,20,30,5,10,50]
 * 输出：65
 * 解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
 * <p>
 * 输入：nums = [10,20,30,40,50]
 * 输出：150
 * 解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。
 * <p>
 * 输入：nums = [12,17,15,13,10,11,12]
 * 输出：33
 * 解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。
 * <p>
 * 输入：nums = [100,10,1]
 * 输出：100
 * <p>
 * https://leetcode.cn/problems/maximum-ascending-subarray-sum/
 */
public class _1800_MaximumAscendingSubarraySum {

    public static void main(String[] args) {
        String x = "[10,20,30,5,10,50]";
        System.out.println(maxAscendingSum(stringToIntegerArray(x)));
        String y = "[12,17,15,13,10,11,12]";
        System.out.println(maxAscendingSum2(stringToIntegerArray(y)));
    }

    //模拟
    public static int maxAscendingSum(int[] nums) {
        int res = 0;
        int cur = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur += nums[i];
            } else {
                cur = nums[i];
            }
            res = Math.max(res, cur);
        }

        return res;
    }

    // 动态规划
    public static int maxAscendingSum2(int[] nums) {
        int res = 0;
        int i = 0;
        while (i < nums.length) {
            int sum = nums[i++];
            while (i < nums.length && nums[i] > nums[i - 1]) {
                sum += nums[i++];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
