package com.laychv.leetcode;

import java.util.Arrays;

public class _34_FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[] a = {2, 2};
        System.out.println(Arrays.toString(searchRange2(a, 2)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = getLeft(nums, target);
        int right = getRight(nums, target);
        if (left == -2 || right == -2) {
            return new int[]{-1, -1};
        }
        if (right - left > 1) {
            return new int[]{left + 1, right - 1};
        }
        return new int[]{-1, -1};
    }

    public static int getLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int border = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
                border = right;
            } else {
                left = mid + 1;
            }
        }
        return border;
    }

    public static int getRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int border = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                border = left;
            }
        }
        return border;
    }

    public static int[] searchRange2(int[] nums, int target) {
        int left = getRange(nums, target);
        int right = getRange(nums, target + 1) - 1;
        if (left <= right) {
            return new int[]{left, right};
        }
        return new int[]{-1, -1};
    }

    static int getRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }
}
