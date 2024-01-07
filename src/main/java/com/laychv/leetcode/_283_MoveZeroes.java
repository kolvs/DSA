package com.laychv.leetcode;

/**
 * 283. 移动零 🟢
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 * 输入: nums = [0,0,1]
 * 输出: [1,0,0]
 * <p>
 * https://leetcode.cn/problems/move-zeroes/?favorite=2cktkvj
 */
public class _283_MoveZeroes {

    /**
     * 两次遍历
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null) return;
        int j = 0;
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 一次遍历
     */
    public static void moveZeroes2(int[] nums) {
        if (nums == null) return;
        //两个指针i和j
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j++] = t;
            }
        }
    }

    /**
     * 一次遍历，使用双指针
     */
    static void moveZeroes3(int[] nums) {
        if (nums.length == 0) return;
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] != 0) {
                swap(nums, l, r);//
                l++;
            }
            r++;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
