package com.laychv.leetcode;

/**
 * 704. 二分查找 🟢
 * <p>
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * 提示：
 * 你可以假设 nums中的所有元素是不重复的。
 * n将在[1, 10000]之间。nums的每个元素都将在[-9999, 9999]之间。
 * <p>
 * https://leetcode.cn/problems/binary-search
 */
public class _704_BinarySearch {

    public static void main(String[] args) {
        int[] x = {-1, 0, 3, 5, 9, 12};
        System.out.println(binarySearch(x, 9));
        int[] y = {-1, 0, 5};
        System.out.println(binarySearch2(y, 2));
    }

    /**
     * [left,right]
     * 左闭右闭
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;// [left,right]
        while (left <= right) { // [left,right] 注意 <=
            int mid = left + ((right - left) >> 1); // 注意 left + (right - left) / 2
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;// [mid + 1,right] 注意 +1
            } else if (nums[mid] > target) {
                right = mid - 1;// [left,mid - 1] 注意 -1
            }
        }
        return -1;
    }

    /**
     * [left,right)
     * 左闭右开
     */
    public static int binarySearch2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;// [left,right)
        while (left < right) {//[left,right]
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;//[left,right)
            } else if (nums[mid] > target) {
                right = mid; // [left,right)
            }
        }
        return -1;
    }
}
