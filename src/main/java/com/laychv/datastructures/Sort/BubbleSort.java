package com.laychv.datastructures.Sort;

import java.util.Arrays;

/**
 * Bubble sort
 * O(n²)
 * 稳定的
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {5, 8, 6, 3, 9, 2, 1, 7};
        sort(array);
        System.out.println(Arrays.toString(array));
        sort2(array);
        System.out.println(Arrays.toString(array));
        sort3(array);
        System.out.println(Arrays.toString(array));
        sort4(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 未优化
     * @param x
     */
    private static void sort4(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - i - 1; j++) {
                int t = 0, a = x[j], b = x[j + 1];
                if (x[j] > x[j + 1]) {
                    t = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = t;
                }
            }
        }
    }

    /**
     * 未优化版
     * 一边比较一边向后两两交换，
     * 将最大值 / 最小值冒泡到最后一位；
     *
     * @param a
     */
    private static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    // 如果左边的数大于右边的数，则交换，保证右边的数字最大
                    swap(a, j, j + 1);
                }
            }
        }
    }

    /**
     * 经过优化的写法：
     * 使用一个变量记录当前轮次的比较是否发生过交换，
     * 如果没有发生交换表示已经有序，不再继续排序；
     *
     * @param a
     */
    private static void sort2(int[] a) {
        // 初始时 swapped 为 true，否则排序过程无法启动
        boolean swapped = true;
        for (int i = 0; i < a.length - 1; i++) {
            // 如果没有发生过交换，说明剩余部分已经有序，排序完成
            if (!swapped) break;
            // 设置 swapped 为 false，如果发生交换，则将其置为 true
            swapped = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    // 如果左边的数大于右边的数，则交换，保证右边的数字最大
                    swap(a, j, j + 1);
                    // 表示发生了交换
                    swapped = true;
                }
            }
        }
    }

    /**
     * 进一步优化的写法：
     * 除了使用变量记录当前轮次是否发生交换外，
     * 再使用一个变量记录上次发生交换的位置，
     * 下一轮排序时到达上次交换的位置就停止比较。
     *
     * @param a
     */
    private static void sort3(int[] a) {
        boolean swapped = true;
        // 最后一个没有经过排序的元素的下标
        int indexOfLastUnsortedElement = a.length - 1;
        // 上次发生交换的位置
        int swappedIndex = -1;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < indexOfLastUnsortedElement; i++) {
                if (a[i] > a[i + 1]) {
                    // 如果左边的数大于右边的数，则交换，保证右边的数字最大
                    swap(a, i, i + 1);
                    // 表示发生了交换
                    swapped = true;
                    // 更新交换的位置
                    swappedIndex = i;
                }
            }
            // 最后一个没有经过排序的元素的下标就是最后一次发生交换的位置
            indexOfLastUnsortedElement = swappedIndex;
        }
    }

    static void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[j] ^ a[i];
        a[i] = a[i] ^ a[j];
    }
}
