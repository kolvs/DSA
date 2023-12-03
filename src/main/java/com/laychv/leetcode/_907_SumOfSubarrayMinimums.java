package com.laychv.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 907. 子数组的最小值之和 🟠
 * <p>
 * 给定一个整数数组 arr，找到 min(b)的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 * <p>
 * 输入：arr = [3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * <p>
 * 输入：arr = [11,81,94,43,3]
 * 输出：444
 * <p>
 * 提示：
 * 1 <= arr.length <= 3 * 104
 * 1 <= arr[i] <= 3 * 104
 * <p>
 * https://leetcode.cn/problems/sum-of-subarray-minimums
 */
public class _907_SumOfSubarrayMinimums {

    public static void main(String[] args) {
        System.out.println("17->:" + sumSubarrayMins(new int[]{3, 1, 2, 4}));
        System.out.println("17->:" + sumSubarrayMins2(new int[]{3, 1, 2, 4}));
        System.out.println("444->:" + sumSubarrayMins(new int[]{11, 81, 94, 43, 3}));
        System.out.println("444->:" + sumSubarrayMins2(new int[]{11, 81, 94, 43, 3}));
        System.out.println("593->:" + sumSubarrayMins2(new int[]{71,55,82,55}));
    }

    /**
     * 动态规划
     */
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long res = 0;
        int MOD = (int) (1e9 + 7);

        int[] dp = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            //找到小于等于当前数组元素值的之前的元素
            while (!deque.isEmpty() && arr[deque.peek()] > arr[i]) {
                deque.pop();
            }
            //计算当前数组元素值作为最小值的范围
            int k = deque.isEmpty() ? (i + 1) : (i - deque.peek());
            dp[i] = k * arr[i] + (deque.isEmpty() ? 0 : dp[i - k]);
            res = (res + dp[i]) % MOD;
            deque.push(i);
        }

        return (int) res;
    }

    /**
     * 单调栈
     */
    public static int sumSubarrayMins2(int[] arr) {
        // 处理边界情况
        if (arr == null || arr.length == 0) return 0;

        int MOD = (int) (1e9 + 7);
        int n = arr.length;
        // 每个元素辐射范围的左边界
        int[] left = new int[n];
        // 每个元素辐射范围的右边界
        int[] right = new int[n];

        Deque<Integer> deque = new ArrayDeque<>();

        // 第一次循环先找到所有元素的左边界
        for (int i = 0; i < n; i++) {
            // 向左找第一个小于等于E的元素
            while (!deque.isEmpty() && arr[deque.peek()] > arr[i]) {
                deque.pop();
            }
            // 设立一个最左边界-1
            if (deque.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = deque.peek();
            }
            // 下标入栈，方便同时得到i和A[i]
            deque.push(i);
        }

        // 第二次循环找到所有元素的右边界
        deque.clear();
        for (int i = n - 1; i >= 0; i--) {
            // 向右找第一个小于E的元素
            while (!deque.isEmpty() && arr[deque.peek()] >= arr[i]) {
                deque.pop();
            }
            // 设立一个最右边界n
            if (deque.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = deque.peek();
            }
            // 下标入栈，方便同时得到i和A[i]
            deque.push(i);
        }

        // 按照贡献度计算即可
        // 注意此处left[i]和right[i]实际上记录的是左边界-1和右边界+1，和上面思路中有些区别，便于计算
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + (long) (i - left[i]) * (right[i] - i) * arr[i]) % MOD;
        }
        return (int) res;
    }

}
