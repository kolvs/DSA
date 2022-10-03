package com.laychv.leetcode.dynamic_programming;

import java.util.List;

import static com.laychv.common.PrintIntegerArray.stringToInt2dList;


/**
 * 120. 三角形最小路径和
 * <p>
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
 * <p>
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class _120_Triangle {

    public static void main(String[] args) {
        String line = "";
        List<List<Integer>> triangle = stringToInt2dList(line);
        int ret = new _120_Triangle().minimumTotal(triangle);
        String out = String.valueOf(ret);
        System.out.print(out);
    }

    /**
     * 时间复杂度：O(N²)，N 为三角形的行数。
     * 空间复杂度：O(N²)，N 为三角形的行数。
     */
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
    public int minimumTotal2(List<List<Integer>> triangle) {
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