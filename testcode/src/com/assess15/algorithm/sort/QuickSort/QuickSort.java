package com.assess15.algorithm.sort.QuickSort;

import java.util.Arrays;

/**
 * 快速排序
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{11, 5, 8, 6, 3, 9, 2, 1, 4, 7};
        int[] sort = sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(sort));
    }

    public static int[] sort(int[] arr, int left, int right) {
        if (left < right) {
            int index = partition(arr, left, right);
            sort(arr, left, index - 1);
            sort(arr, index + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int pivot, int right) {
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
