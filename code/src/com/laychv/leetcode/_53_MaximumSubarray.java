package com.laychv.leetcode;

import static com.laychv.common.PrintIntegerArray.stringToIntegerArray;

/**
 * 53. 最大子数组和
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * <p>
 * https://leetcode.cn/problems/maximum-subarray/
 * <p>
 * 同源：1800
 */
class _53_MaximumSubarray {

    public static void main(String[] args) {
        String x = "[-2,1,-3,4,-1,2,1,-5,4]";
        System.out.println(maxSubArray(stringToIntegerArray(x)));
        System.out.println(maxSubArray2(stringToIntegerArray(x)));
    }

    // dp
    public static int maxSubArray(int[] nums) {
        // 动态规划
        // 状态转移方程
        // f(i) = max(m - 1, m)
        int pre = 0;
        int maxAns = nums[0];
        for (int n : nums) {
            pre = Math.max(pre + n, n);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    // dp
    public static int maxSubArray2(int[] nums) {
        int res = nums[0];
        int sum = 0;

        for (int n : nums) {
            if (sum > 0) {
                sum += n;
            } else {
                sum = n;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}