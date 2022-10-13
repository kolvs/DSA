package com.laychv.leetcode;

/**
 * 11. 盛最多水的容器 🟡
 * <p>
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * https://leetcode.cn/problems/container-with-most-water
 */
public class _11_ContainerWithMostWater {

    public static void main(String[] args) {
        int[] x = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(x));
        System.out.println(maxArea2(x));
    }

    /**
     * 双指针
     * https://leetcode.cn/problems/container-with-most-water/solution/11-sheng-zui-duo-shui-de-rong-qi-shuang-fi2zm/
     */
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;

        while (i < j) {
            max = height[i] < height[j] ? Math.max(max, (j - i) * height[i++]) : Math.max(max, (j - i) * height[j--]);
        }
        return max;
    }

    /**
     * 左右指针
     * S(i,j) = min(height[i],height[j]) * (j - i)
     * res = max(res,S(i,j))
     * https://leetcode.cn/problems/container-with-most-water/solution/container-with-most-water-shuang-zhi-zhen-fa-yi-do/
     */
    public static int maxArea2(int[] a) {
        int res = 0;
        for (int i = 0, j = a.length - 1; i < j; ) {
            res = a[i] < a[j] ? Math.max(res, (j - i) * a[i++]) : Math.max(res, (j - i) * a[j--]);
        }
        return res;
    }

}
