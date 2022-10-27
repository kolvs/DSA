package com.laychv.leetcode;

/**
 * 1822. 数组元素积的符号🟢
 * 已知函数signFunc(x) 将会根据 x 的正负返回特定值：
 * 如果 x 是正数，返回 1 。
 * 如果 x 是负数，返回 -1 。
 * 如果 x 是等于 0 ，返回 0 。
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 * 返回 signFunc(product) 。
 * <p>
 * 输入：nums = [-1,-2,-3,-4,3,2,1]
 * 输出：1
 * 解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
 * <p>
 * 输入：nums = [1,5,0,2,-3]
 * 输出：0
 * 解释：数组中所有值的乘积是 0 ，且 signFunc(0) = 0
 * <p>
 * 输入：nums = [-1,1,-1,1,-1]
 * 输出：-1
 * 解释：数组中所有值的乘积是 -1 ，且 signFunc(-1) = -1
 * <p>
 * 提示：
 * 1 <= nums.length <= 1000
 * -100 <= nums[i] <= 100
 * <p>
 * https://leetcode.cn/problems/sign-of-the-product-of-an-array
 */
public class _1822_SignOfTheProductOfAnArray {

    public static void main(String[] args) {
        System.out.println("1->:" + arraySign2(new int[]{-1, -2, -3, -4, 3, 2, 1}));
        System.out.println("0->:" + arraySign(new int[]{1, 5, 0, 2, -3}));
        System.out.println("-1->:" + arraySign2(new int[]{-1, 1, -1, 1, -1}));
    }

    public static int arraySign(int[] nums) {
        int res = 1;
        for (int n : nums) {
            if (n == 0) return 0;
            if (n < 0) res *= -1;
        }
        return res;
    }

    public static int arraySign2(int[] nums) {
        boolean b = false;
        for (int n : nums) {
            if (n == 0) return 0;
            if (n < 0) b = !b;
        }
        return b ? -1 : 1;
    }
}
