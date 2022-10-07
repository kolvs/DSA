package com.laychv.datastructures.Sort;

import java.util.Arrays;

/**
 * Selection sort
 * O(n^2)
 * 选择排序法是不稳定的
 */

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 3, 4, 1, 9};
        sort(array);
        System.out.println(Arrays.toString(array));
        sort2(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 双重循环遍历数组，每经过一轮比较，找到最小元素的下标，将其交换至首位。
     *
     * @param a
     */
    private static void sort(int[] a) {
        int minIndex;
        for (int i = 0; i < a.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[minIndex] > a[j]) {
                    // 记录最小值的下标
                    minIndex = j;
                }
            }
            swap(a,i,minIndex);
            // 将最小元素交换至首位
//            int temp = a[i];
//            a[i] = a[minIndex];
//            a[minIndex] = temp;
        }
    }

    static void swap(int[] a,int i,int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 二元选择排序
     *
     * @param arr
     */
    private static void sort2(int[] arr) {
        int minIndex, maxIndex;
        // i 只需要遍历一半
        for (int i = 0; i < arr.length / 2; i++) {
            minIndex = i;
            maxIndex = i;
            for (int j = i + 1; j < arr.length - i; j++) {
                if (arr[minIndex] > arr[j]) {
                    // 记录最小值的下标
                    minIndex = j;
                }
                if (arr[maxIndex] < arr[j]) {
                    // 记录最大值的下标
                    maxIndex = j;
                }
            }
            // 如果 minIndex 和 maxIndex 都相等，那么他们必定都等于 i，且后面的所有数字都与 arr[i] 相等，此时已经排序完成
            if (minIndex == maxIndex) break;
            // 将最小元素交换至首位
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            // 如果最大值的下标刚好是 i，由于 arr[i] 和 arr[minIndex] 已经交换了，所以这里要更新 maxIndex 的值。
            if (maxIndex == i) maxIndex = minIndex;
            // 将最大元素交换至末尾
            int lastIndex = arr.length - 1 - i;
            temp = arr[lastIndex];
            arr[lastIndex] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }
}
