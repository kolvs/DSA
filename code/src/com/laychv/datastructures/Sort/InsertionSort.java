package com.laychv.datastructures.Sort;

import java.util.Arrays;

/**
 * Insertion sort
 * O(n^2)
 * 插入排序是稳定的排序算法
 * <p>
 * 交换法
 * 移动法
 */

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 4, 7};
        sort(array);
        System.out.println(Arrays.toString(array));
        sort2(array);
        System.out.println(Arrays.toString(array));
    }

    // 交换法插入排序
    private static void sort(int[] a) {
        // 从第二个数开始，往前插入数字
        for (int i = 1; i < a.length; i++) {
            // j 记录当前数字下标
            int j = i;
            // 当前数字比前一个数字小，则将当前数字与前一个数字交换
            while (j >= 1 && a[j] < a[j - 1]) {
                swap(a, j, j - 1);
                // 更新当前数字下标
                j--;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[j] ^ a[i];
        a[i] = a[i] ^ a[j];
    }

    // 移动法插入排序
    private static void sort2(int[] a) {
        // 从第二个数开始，往前插入数字
        for (int i = 0; i < a.length; i++) {
            int cur = a[i];
            int j = i - 1;
            // 寻找插入位置的过程中，不断地将比 currentNumber 大的数字向后挪
            while (j >= 0 && cur < a[i]) {
                a[j + 1] = a[j];
                j--;
            }
            // 两种情况会跳出循环：1. 遇到一个小于或等于 currentNumber 的数字，跳出循环，currentNumber 就坐到它后面。
            // 2. 已经走到数列头部，仍然没有遇到小于或等于 currentNumber 的数字，也会跳出循环，此时 j 等于 -1，currentNumber 就坐到数列头部。
            a[j + 1] = cur;
        }
    }
}