package com.laychv.leetcode;

import java.util.Arrays;

/**
 * 300. 最长递增子序列 🟡
 * <p>
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * <p>
 * https://leetcode.cn/problems/longest-increasing-subsequence
 */
public class _300_LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] x = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] y = {0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS(x));
        System.out.println(lengthOfLIS2(y));
        System.out.println(lengthOfLIS3(x));
    }

    /**
     * 动态规划
     * TC: O(n²)
     * SC: O(n)
     */
    public static int lengthOfLIS(int[] nums) {
        // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // base case：dp 数组全都初始化为 1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 动态规划
     */
    public static int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 动态规划 + 二分查找
     */
    public static int lengthOfLIS3(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }

}
