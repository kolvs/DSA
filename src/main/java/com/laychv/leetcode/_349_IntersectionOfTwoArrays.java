package com.laychv.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集 🟢
 * <p>
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。
 * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 * <p>
 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 * https://leetcode.cn/problems/intersection-of-two-arrays/
 */
public class _349_IntersectionOfTwoArrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    /**
     * HashSet
     * 利用hashset去重的特性
     **/
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int k : nums1) {
            set1.add(k);
        }
        for (int k : nums2) {
            if (set1.contains(k)) {
                set2.add(k);
            }
        }

        int[] res = new int[set2.size()];
        int j = 0;
        for (int i : set2) {
            res[j++] = i;
        }
        return res;
    }
}
