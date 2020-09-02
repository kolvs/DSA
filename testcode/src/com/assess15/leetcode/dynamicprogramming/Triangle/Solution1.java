package com.assess15.leetcode.dynamicprogramming.Triangle;

import java.util.List;

/**
 * 时间复杂度：O(N²)，N 为三角形的行数。
 * 空间复杂度：O(N²)，N 为三角形的行数。
 */
class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}