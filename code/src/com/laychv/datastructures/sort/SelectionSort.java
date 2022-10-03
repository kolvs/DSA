package com.laychv.datastructures.sort;

import java.util.Arrays;

/**
 * 选择排序
 */

public class SelectionSort {

    private static void sort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        // 总共要经过 N-1 轮比较
        // [0,array.length)
        // [0,array.length - 1]
        for (int i = 0; i < array.length - 1; i++) {
            // 最小值
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 8,3};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
