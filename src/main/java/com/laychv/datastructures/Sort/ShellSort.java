package com.laychv.datastructures.Sort;

import java.util.Arrays;

/**
 * 希尔排序
 * O(nlogn)
 * 不稳定
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] x = {11, 5, 8, 6, 3, 9, 2, 1, 4, 7};
        shellSort(x);
        System.out.println(Arrays.toString(x));

        System.out.println(Arrays.binarySearch(x, 11));

        int[] y = {5, 6, 1, 2, 3, 0, 8};
        shellSort2(y);
        System.out.println(Arrays.toString(y));
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

    public static void shellSort2(int[] arr) {
        // 间隔序列，在希尔排序中我们称之为增量序列
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从 gap 开始，按照顺序将每个元素依次向前插入自己所在的组
            for (int i = gap; i < arr.length; i++) {
                // currentNumber 站起来，开始找位置
                int currentNumber = arr[i];
                // 该组前一个数字的索引
                int preIndex = i - gap;
                while (preIndex >= 0 && currentNumber < arr[preIndex]) {
                    // 向后挪位置
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                // currentNumber 找到了自己的位置，坐下
                arr[preIndex + gap] = currentNumber;
            }
        }
    }

}
