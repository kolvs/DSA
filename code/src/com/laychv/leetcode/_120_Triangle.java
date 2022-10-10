package com.laychv.leetcode;

import java.util.List;

import static com.laychv.common.PrintIntegerArray.stringToInt2dList;

/**
 * 120. 三角形最小路径和
 * <p>
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
 * <p>
 * 输入：triangle = [[-10]]
 * 输出：-10
 * <p>
 * https://leetcode.cn/problems/triangle
 */
class _120_Triangle {

    public static void main(String[] args) {
        String x = "[[2],[3,4],[6,5,7],[4,1,8,3]]";
        System.out.print(minimumTotal(stringToInt2dList(x)));
        System.out.print(minimumTotal2(stringToInt2dList(x)));
    }

    /**
     * 时间复杂度：O(N²)，N 为三角形的行数。
     * 空间复杂度：O(N²)，N 为三角形的行数。
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * @link https://leetcode.cn/problems/triangle/solution/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/
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
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}