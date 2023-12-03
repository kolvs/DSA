package com.laychv.leetcode;

/**
 * 80. 删除有序数组中的重复项 II 🟠
 * <p>
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 说明：
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 * ---print(nums[i]);
 * }
 * <p>
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 * <p>
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
 */
public class _80_RemoveDuplicatesFromSortedArray_II {

    public static void main(String[] args) {
        System.out.println("5->:" + removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println("7->:" + removeDuplicates4(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }

    /**
     * 双指针-快慢指针
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int n = nums.length;
        if (n <= 2) return n;

        int slow = 2, fast = 2;

        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    // 移除重复项通用解法
    // k为重复项的个数
    public static int removeDuplicates4(int[] nums) {
        return remove(nums, 2);
    }

    private static int remove(int[] nums, int k) {
        int res = 0;
        for (int n : nums) {
            if (res < k || nums[res - k] != n) {
                nums[res++] = n;
            }
        }
        return res;
    }

}
