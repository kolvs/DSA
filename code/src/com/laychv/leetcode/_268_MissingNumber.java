package com.laychv.leetcode;

import java.util.Arrays;

/**
 * 268. 丢失的数字 🟢
 * <p>
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * <p>
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * nums 中的所有数字都 独一无二
 * <p>
 * https://leetcode.cn/problems/missing-number
 */
public class _268_MissingNumber {

    public static void main(String[] args) {
        System.out.println("2->:" + missingNumber(new int[]{3, 0, 1}));
        System.out.println("2->:" + missingNumber2(new int[]{3, 0, 1}));
        System.out.println("2->:" + missingNumber3(new int[]{3, 0, 1}));
        System.out.println("8->:" + missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println("8->:" + missingNumber2(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println("8->:" + missingNumber3(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    /**
     * 亦或 ^
     * n ^ n = 0 (n >= 0)
     * n ^ 0 = n
     * 0 ^ n = n
     */
    public static int missingNumber(int[] nums) {
        int res = 0;
        // 第一次循环：对[1,n]和res亦或
        for (int i = 0; i <= nums.length; i++) {
            res ^= i;
        }
        // 第二次循环：res和nums[i]亦或
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }

    /**
     * 排序
     * 从排序中找到丢失的数字：判断nums[i]是否与index相等，不相等即丢失的数字
     * index: 0 1 2 3
     * sort:  0 1   3
     */
    public static int missingNumber2(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                res = i;
            }
        }
        return res;
    }

    /**
     * 等差数列
     */
    public static int missingNumber3(int[] nums) {
        int n = nums.length;
        int arrSum = 0;
        int total = n * (n + 1) / 2;
        for (int i : nums) {
            arrSum += i;
        }
        return total - arrSum;
    }

}
