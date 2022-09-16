package com.laychv.leetcode.dynamic_programming._53_Maximum_Subarray;

class Solution {
    public int maxSubArray(int[] nums) {
        // 动态规划
        // 状态转移方程
        // f(i) = max(m - 1, m)
        int pre = 0;
        int maxAns = nums[0];
        for (int n : nums) {    
            pre = Math.max(pre + n, n);
            maxAns = Math.max(maxAns,pre);
        }
        return maxAns;
    }
}