package com.laychv.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 */
public class _215_ {

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 6, 4};
        int[] b = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(a, 2));
        System.out.println(findKthLargest2(b, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    public static int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n - k];
    }
}