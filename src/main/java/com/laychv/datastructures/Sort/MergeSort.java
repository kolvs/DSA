package com.laychv.datastructures.Sort;

import java.util.Arrays;

/**
 * 归并排序
 * O(nlogn)
 * 稳定
 */

public class MergeSort {

    public static void main(String[] args) {
        int[] x = {11, 5, 8, 6, 3, 9, 2, 1, 4, 7};
        System.out.println(Arrays.toString(mergeSort(x)));
        int[] y = {11, 5, 8, 6, 3, 9, 2, 1, 4, 7};
        mergeSort2(y);
        System.out.println(Arrays.toString(y));
    }

    public static int[] mergeSort(int[] array) {
        if (array.length < 2) return array;
        // 把原数组分为左右2部分
        int middle = (int) Math.floor(array.length / 2f);
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);
        // 递归合并
        return mergeSort(mergeSort(left), mergeSort(right));
    }

    private static int[] mergeSort(int[] left, int[] right) {
        // 存放排序后的数组
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }

    private static void mergeSort2(int[] a) {
        if (a.length == 0) return;
        int[] len = new int[a.length];
        mergeSort2(a, 0, a.length - 1, len);
    }

    // 对 a 的 [start, end] 区间归并排序
    private static void mergeSort2(int[] a, int start, int end, int[] res) {
        // 只剩下一个数字，停止拆分
        if (start == end) return;
        int mid = (start + end) / 2;
        // 拆分左边区域，并将归并排序的结果保存到 result 的 [start, middle] 区间
        mergeSort2(a, start, mid, res);
        // 拆分右边区域，并将归并排序的结果保存到 result 的 [middle + 1, end] 区间
        mergeSort2(a, mid + 1, end, res);
        // 合并左右区域到 result 的 [start, end] 区间
        merge(a, start, end, res);
    }

    // 将 result 的 [start, middle] 和 [middle + 1, end] 区间合并
    private static void merge(int[] a, int start, int end, int[] res) {
        int end1 = (start + end) / 2;
        int start2 = end1 + 1;
        // 用来遍历数组的指针
        int index1 = start;
        int index2 = start2;
        while (index1 <= end1 && index2 <= end) {
            if (a[index1] <= a[index2]) {
                res[index1 + index2 - start2] = a[index1++];
            } else {
                res[index1 + index2 - start2] = a[index2++];
            }
        }
        // 将剩余数字补到结果数组之后
        while (index1 <= end1) {
            res[index1 + index2 - start2] = a[index1++];
        }
        while (index2 <= end) {
            res[index1 + index2 - start2] = a[index2++];
        }
        // 将 result 操作区间的数字拷贝到 arr 数组中，以便下次比较
        while (start <= end) {
            a[start] = res[start++];
        }
    }
}
