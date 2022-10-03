package com.laychv.datastructures.sort;

import java.util.Arrays;

/**
 * 插入排序
 */

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 4, 7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < array.length; i++) {
            // 记录要插入的数据
            int temp = array[i];
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                array[j] = temp;
            }
        }
    }


    public static void sort2(int[] nums) {
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