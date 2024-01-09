package com.laychv.leetcode;

/**
 * 209. 长度最小的子数组 🟠
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * <p>
 * 进阶：
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 * <p>
 * https://leetcode.cn/problems/minimum-size-subarray-sum/description/
 */
public class _209_MinimumSizeSubarraySum {

    public static void main(String[] args) {
        System.out.println("2:" + minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println("2:" + minSubArrayLen2(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    /**
     * 滑动窗口
     **/
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int res = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    /**
     * 暴力
     * leetcode error
     */
    public static int minSubArrayLen2(int target, int[] nums) {
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    res = Math.min(res, j - i + 1);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
