package com.laychv.leetcode;

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II 🟠
 * <p>
 * 给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * 提示：1 <= n <= 20
 * <p>
 * https://leetcode.cn/problems/spiral-matrix-ii/
 */
public class _59_SpiralMatrix_II {

    public static void main(String[] args) {
        System.out.println("[[1,2,3],[8,9,4],[7,6,5]]->:");
        System.out.println(Arrays.deepToString(generateMatrix(3)));
        System.out.println(Arrays.deepToString(generateMatrix2(3)));
    }

    public static int[][] generateMatrix(int n) {
        int loop = 0;
        int[][] res = new int[n][n];
        int start = 0;
        int cout = 1;
        int i, j;

        while (loop++ < n / 2) {
            for (j = start; j < n - loop; j++) {
                res[start][j] = cout++;
            }
            for (i = start; i < n - loop; i++) {
                res[i][j] = cout++;
            }
            for (; j >= loop; j--) {
                res[i][j] = cout++;
            }
            for (; i >= loop; i--) {
                res[i][j] = cout++;
            }
            start++;
        }

        if (n % 2 == 1) {
            res[start][start] = cout;
        }

        return res;
    }

    public static int[][] generateMatrix2(int n) {
        int[][] matrix = new int[n][n];
        int upper_bound = 0, lower_bound = n - 1;
        int left_bound = 0, right_bound = n - 1;
        int num = 1;

        while (num <= n * n) {
            if (upper_bound <= lower_bound) {
                // 在顶部从左向右遍历
                for (int j = left_bound; j <= right_bound; j++) {
                    matrix[upper_bound][j] = num++;
                }
                // 上边界下移
                upper_bound++;
            }

            if (left_bound <= right_bound) {
                // 在右侧从上向下遍历
                for (int i = upper_bound; i <= lower_bound; i++) {
                    matrix[i][right_bound] = num++;
                }
                // 右边界左移
                right_bound--;
            }

            if (upper_bound <= lower_bound) {
                // 在底部从右向左遍历
                for (int j = right_bound; j >= left_bound; j--) {
                    matrix[lower_bound][j] = num++;
                }
                // 下边界上移
                lower_bound--;
            }

            if (left_bound <= right_bound) {
                // 在左侧从下向上遍历
                for (int i = lower_bound; i >= upper_bound; i--) {
                    matrix[i][left_bound] = num++;
                }
                // 左边界右移
                left_bound++;
            }
        }

        return matrix;
    }

}
