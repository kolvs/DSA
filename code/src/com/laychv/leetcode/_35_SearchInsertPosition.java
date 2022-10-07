package com.laychv.leetcode;

/**
 * 35. 搜索插入位置
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * https://leetcode.cn/problems/search-insert-position/
 */
class _35_SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        System.out.print(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }
}
