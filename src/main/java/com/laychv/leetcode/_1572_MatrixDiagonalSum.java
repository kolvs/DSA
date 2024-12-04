package com.laychv.leetcode;

/**
 * 1572. 矩阵对角线元素的和 🟢
 * <p>
 * 输入：mat = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：25
 * 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 * 请注意，元素 mat[1][1] = 5 只会被计算一次。
 * 示例  2：
 * <p>
 * 输入：mat = [[1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1]]
 * 输出：8
 * 示例 3：
 * <p>
 * 输入：mat = [[5]]
 * 输出：5
 * 提示：
 * n == mat.length == mat[i].length
 * 1 <= n <= 100
 * 1 <= mat[i][j] <= 100
 * <p>
 * https://leetcode.cn/problems/matrix-diagonal-sum/description/
 */
public class _1678_GoalParserInterpretation {

    public static void main(String[] args) {

    }

    public static int diagonalSum(int[][] mat) {
        int len = mat.length, sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; ++j) {
                if (i == j || i + j == n - 1) {
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }

    public static int diagonalSum2(int[][] mat) {
        int len = mat.length, sum = 0, mid = n / 2;
        for (int i = 0; i < len; i++) {
            sum += mat[i][j] + mat[i][n - 1 - i];
        }
        return sum - mat[mid][mid] * (n & 1);
    }
}
