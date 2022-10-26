package com.laychv.leetcode;

import java.util.ArrayDeque;

/**
 * 862. 和至少为 K 的最短子数组 🔴
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。
 * 如果不存在这样的 子数组 ，返回 -1 。子数组 是数组中 连续 的一部分。
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：1
 * <p>
 * 输入：nums = [1,2], k = 4
 * 输出：-1
 * <p>
 * 输入：nums = [2,-1,2], k = 3
 * 输出：3
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^5 <= nums[i] <= 10^5
 * 1 <= k <= 10^9
 * <p>
 * https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/
 */
public class _862_ShortestSubarrayWithSumAtLeast_K {

    public static void main(String[] args) {
        System.out.println("1->:" + shortestSubarray(new int[]{1}, 1));
        System.out.println("-1->:" + shortestSubarray(new int[]{1, 2}, 4));
        System.out.println("3->:" + shortestSubarray(new int[]{2, -1, 2}, 3));
    }

    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int res = n + 1;

        long[] s = new long[n + 1];
        // 计算前缀和
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            long curS = s[i];
            while (!deque.isEmpty() && curS - s[deque.peekFirst()] >= k) {
                res = Math.min(res, i - deque.pollFirst()); // 优化一
            }
            while (!deque.isEmpty() && s[deque.peekLast()] >= curS) {
                deque.pollLast(); // 优化二
            }
            deque.addLast(i);
        }

        return res > n ? -1 : res;
    }
}
