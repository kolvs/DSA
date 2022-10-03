package com.laychv.datastructures.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] array = new int[]{11, 5, 8, 6, 3, 9, 2, 1, 4, 7};
        shellSort(array);
        int i = Arrays.binarySearch(array, 11);
        System.out.println(Arrays.toString(array));
        System.out.println(i);
    }

    public static void shellSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }

}
