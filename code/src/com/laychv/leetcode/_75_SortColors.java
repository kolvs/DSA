package com.laychv.leetcode;

import java.util.Arrays;

/**
 * 75. 颜色分类 🟠
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * <p>
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * <p>
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 * <p>
 * 进阶：
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * https://leetcode.cn/problems/sort-colors/
 */
public class _75_SortColors {

    public static void main(String[] args) {
        int[] a = {2, 0, 2, 1, 1, 0};
        sortColors(a);
        System.out.println(Arrays.toString(a));
        int[] b = {2, 0, 1};
        sortColors(b);
        System.out.println(Arrays.toString(b));
    }

    /***双指针***/
    public static void sortColors(int[] nums) {
        int i0 = 0, i1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            nums[i] = 2;
            if (n < 2) {
                nums[i1++] = 1;
            }
            if (n < 1) {
                nums[i0++] = 0;
            }
        }
    }
}
