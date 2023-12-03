package com.laychv.leetcode;

import java.util.Arrays;

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

    public static void main(String[] args) {
        int[] x = {0, 1, 0, 3, 12};
        moveZeroes(x);
        System.out.println(Arrays.toString(x));

        int[] y = {0, 0, 1};
        moveZeroes2(y);
        System.out.println(Arrays.toString(y));
    }

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
}
