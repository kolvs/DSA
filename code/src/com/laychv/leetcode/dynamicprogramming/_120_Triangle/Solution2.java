package com.laychv.leetcode.dynamicprogramming._120_Triangle;

import java.util.List;

/**
 * @link https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/
 * <p>
 * 解法三：动态规划
 * 定义二维 dp 数组,「自底向上的递推」。
 * <p>
 * 1. 定义状态
 * dp[i][j] 表示从点 (i, j)(i,j) 到底边的最小路径和。
 * <p>
 * 2. 状态转移
 * dp[i][j] = min(dpp[i+1][j] , dp[i+1][j+1]) + triangle[i][j]
 * <p>
 * 空间优化
 * <p>
 * 时间复杂度：O(N²)，N为三角形的行数。
 * 空间复杂度：O(N)，N为三角形的行数。
 */
class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}