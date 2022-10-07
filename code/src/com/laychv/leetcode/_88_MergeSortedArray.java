package com.laychv.leetcode;

import java.util.Arrays;

import static com.laychv.common.PrintIntegerArray.integerArrayToString;
import static com.laychv.common.PrintIntegerArray.stringToIntegerArray;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * <p>
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 * <p>
 * https://leetcode-cn.com/problems/merge-sorted-array
 */
class _88_MergeSortedArray {

    public static void main(String[] args) {
        String s1 = "[1,2,3,0,0,0]";
        String s2 = "[2,5,6]";
        int m = 3;
        int n = 3;
        int[] nums1 = stringToIntegerArray(s1);
        int[] nums2 = stringToIntegerArray(s2);
        merge(nums1, m, nums2, n);
        System.out.println(integerArrayToString(nums1));
//        merge2(nums1, m, nums2, n);
//        System.out.println(integerArrayToString(nums1));
    }

    // api
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    // 双指针
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int cur;
        int[] sorted = new int[m + n];

        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }

        for (int i = 0; i != m + n; i++) {
            nums1[i] = sorted[i];
        }
    }
}