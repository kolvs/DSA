package com.laychv.leetcode.dynamic_programming;

import static com.laychv.common.PrintIntegerArray.stringToIntegerArray;

class _53_Maximum_Subarray {

    public static void main(String[] args) {
        String line ="";
        int[] nums = stringToIntegerArray(line);
        int ret = new _53_Maximum_Subarray().maxSubArray(nums);
        String out = String.valueOf(ret);
        System.out.print(out);
    }

    public int maxSubArray(int[] nums) {
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
}