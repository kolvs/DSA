package com.assess15.algorithm;

import java.util.Arrays;

/**
 * 插入排序
 */

public class insertSort {
    public static void main(String[] args) {
        int[] array = new int[]{11, 5, 8, 6, 3, 9, 2, 1, 4, 7};
        sort(array);
        System.out.println(Arrays.toString(array));
        // JDk 自带排序算法
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] nums) {
        if (nums.length <= 1) return;

        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;

            while (j > 0 && temp < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }

            if (j != i) {
                nums[j] = temp;
            }
        }
    }
}
