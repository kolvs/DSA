package com.laychv.leetcode;

import java.util.Arrays;

/**
 * 1235. 规划兼职工作 🔴
 * <p>
 * 你打算利用空闲时间来做兼职工作赚些零花钱。
 * 这里有n份兼职工作，每份工作预计从startTime[i]开始到endTime[i]结束，报酬为profit[i]。
 * 给你一份兼职工作表，包含开始时间startTime，结束时间endTime和预计报酬profit三个数组，请你计算并返回可以获得的最大报酬。
 * 注意，时间上出现重叠的 2 份工作不能同时进行。
 * 如果你选择的工作在时间X结束，那么你可以立刻进行在时间X开始的下一份工作。
 * <p>
 * 输入：startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * 输出：120
 * 解释：
 * 我们选出第 1 份和第 4 份工作，
 * 时间范围是 [1-3]+[3-6]，共获得报酬 120 = 50 + 70。
 * <p>
 * 输入：startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
 * 输出：150
 * 解释：
 * 我们选择第 1，4，5 份工作。
 * 共获得报酬 150 = 20 + 70 + 60。
 * <p>
 * 输入：startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
 * 输出：6
 * <p>
 * 提示：
 * 1 <= startTime.length == endTime.length ==profit.length<= 5 * 10^4
 * 1 <=startTime[i] <endTime[i] <= 10^9
 * 1 <=profit[i] <= 10^4
 * <p>
 * https://leetcode.cn/problems/maximum-profit-in-job-scheduling
 */
public class _1235_MaximumProfitInJobScheduling {

    public static void main(String[] args) {
        System.out.println("120->:" + jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));
        System.out.println("150->:" + jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}));
        System.out.println("6  ->:" + jobScheduling(new int[]{1, 1, 1}, new int[]{2, 3, 4}, new int[]{5, 6, 4}));
    }

    /**
     * 动态规划 + 二分
     * startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
     * st:1,et:3,pt:50
     * st:2,et:4,pt:10
     * st:3,et:5,pt:40
     * st:3,et:6,pt:70
     * dp[i] = 50 + 70 = 120
     * 我们首先将兼职工作按结束时间 endTime 从小到大进行排序。使用 dp[i] 表示前 ii 份兼职工作可以获得的最大报酬，
     * 初始时 dp[0]=0，那么对于 i>0，我们有以下转移方程：dp[i]=max(dp[i−1],dp[k]+profit[i−1])
     */
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        // create jobs array
        int[][] jobs = new int[n][];

        // init jobs array
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        // sort jobs: [[1,3,50],[2,4,10],[3,5,40],[3,6,70]]
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
//        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));

        // dp[i] is answer
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int k = binarySearch(jobs, i - 1, jobs[i - 1][0]);
            dp[i] = Math.max(dp[i - 1], dp[k] + jobs[i - 1][2]);
        }
        return dp[n];
    }

    private static int binarySearch(int[][] jobs, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
