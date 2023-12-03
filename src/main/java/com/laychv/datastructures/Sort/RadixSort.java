package com.laychv.datastructures.Sort;

import java.util.Arrays;

/**
 * 基数排序
 * O(n)
 */
public class RadixSort {

    public static void main(String[] args) {
        radixSort(TestSample.x);
        radixSort2(TestSample.x);
        radixSort3(TestSample.x);
        System.out.println(Arrays.toString(TestSample.x));
        System.out.println(Arrays.toString(TestSample.x));
        System.out.println(Arrays.toString(TestSample.x));
    }

    /**
     * 基数排序可以分为以下三个步骤：
     * 找出数组中最大的数字的位数 maxDigitLength
     * 获取数组中每个数字的基数
     * 遍历 maxDigitLength 轮数组，每轮按照基数对其进行排序
     */

    // 首先找到数组中的最大值
    public static void radix(int[] arr) {

        // 找出数组中最大的数字的位数 maxDigitLength
        if (arr == null) return;
        int max = 0;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }

        // 通过遍历一次数组，找到了数组中的最大值 max，然后我们计算这个最大值的位数
        int maxDigitLength = 0;
        while (max != 0) {
            maxDigitLength++;
            max /= 10;
        }

        // 获取基数：方式一
        int mod = 10;
        int dev = 1;
        for (int i = 0; i < maxDigitLength; i++) {
            for (int value : arr) {
                int radix = value % mod / dev;
                // 对基数进行排序
            }
            mod *= 10;
            dev *= 10;
        }

        // 获取基数：方式二
        int devs = 1;
        for (int i = 0; i < maxDigitLength; i++) {
            for (int value : arr) {
                int radix = value / devs % 10;
                // 对基数进行排序
            }
            devs *= 10;
        }

    }

    // LSD
    public static void radixSort(int[] arr) {
        if (arr == null) return;
        // 找出最大值
        int max = 0;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        // 计算最大数字的长度
        int maxDigitLength = 0;
        while (max != 0) {
            maxDigitLength++;
            max /= 10;
        }
        // 使用计数排序算法对基数进行排序
        int[] counting = new int[10];
        int[] result = new int[arr.length];
        int dev = 1;
        for (int i = 0; i < maxDigitLength; i++) {
            for (int value : arr) {
                int radix = value / dev % 10;
                counting[radix]++;
            }
            for (int j = 1; j < counting.length; j++) {
                counting[j] += counting[j - 1];
            }
            // 使用倒序遍历的方式完成计数排序
            for (int j = arr.length - 1; j >= 0; j--) {
                int radix = arr[j] / dev % 10;
                result[--counting[radix]] = arr[j];
            }
            // 计数排序完成后，将结果拷贝回 arr 数组
            System.arraycopy(result, 0, arr, 0, arr.length);
            // 将计数数组重置为 0
            Arrays.fill(counting, 0);
            dev *= 10;
        }
    }

    // 包含负数
    public static void radixSort2(int[] arr) {
        if (arr == null) return;
        // 找出最长的数
        int max = 0;
        for (int value : arr) {
            if (Math.abs(value) > max) {
                max = Math.abs(value);
            }
        }
        // 计算最长数字的长度
        int maxDigitLength = 0;
        while (max != 0) {
            maxDigitLength++;
            max /= 10;
        }
        // 使用计数排序算法对基数进行排序，下标 [0, 18] 对应基数 [-9, 9]
        int[] counting = new int[19];
        int[] result = new int[arr.length];
        int dev = 1;
        for (int i = 0; i < maxDigitLength; i++) {
            for (int value : arr) {
                // 下标调整
                int radix = value / dev % 10 + 9;
                counting[radix]++;
            }
            for (int j = 1; j < counting.length; j++) {
                counting[j] += counting[j - 1];
            }
            // 使用倒序遍历的方式完成计数排序
            for (int j = arr.length - 1; j >= 0; j--) {
                // 下标调整
                int radix = arr[j] / dev % 10 + 9;
                result[--counting[radix]] = arr[j];
            }
            // 计数排序完成后，将结果拷贝回 arr 数组
            System.arraycopy(result, 0, arr, 0, arr.length);
            // 将计数数组重置为 0
            Arrays.fill(counting, 0);
            dev *= 10;
        }
    }


    // MSD
    public static void radixSort3(int[] arr) {
        if (arr == null) return;
        // 找到最大值
        int max = 0;
        for (int value : arr) {
            if (Math.abs(value) > max) {
                max = Math.abs(value);
            }
        }
        // 计算最大长度
        int maxDigitLength = 0;
        while (max != 0) {
            maxDigitLength++;
            max /= 10;
        }
        radixSort(arr, 0, arr.length - 1, maxDigitLength);
    }

    // 对 arr 数组中的 [start, end] 区间进行基数排序
    private static void radixSort(int[] arr, int start, int end, int position) {
        if (start == end || position == 0) return;
        // 使用计数排序对基数进行排序
        int[] counting = new int[19];
        int[] result = new int[end - start + 1];
        int dev = (int) Math.pow(10, position - 1);
        for (int i = start; i <= end; i++) {
            // MSD, 从最高位开始
            int radix = arr[i] / dev % 10 + 9;
            counting[radix]++;
        }
        for (int j = 1; j < counting.length; j++) {
            counting[j] += counting[j - 1];
        }
        // 拷贝 counting，用于待会的递归
        int[] countingCopy = new int[counting.length];
        System.arraycopy(counting, 0, countingCopy, 0, counting.length);
        for (int i = end; i >= start; i--) {
            int radix = arr[i] / dev % 10 + 9;
            result[--counting[radix]] = arr[i];
        }
        // 计数排序完成后，将结果拷贝回 arr 数组
        System.arraycopy(result, 0, arr, start, result.length);
        // 对 [start, end] 区间内的每一位基数进行递归排序
        for (int i = 0; i < counting.length; i++) {
            radixSort(arr, i == 0 ? start : start + countingCopy[i - 1], start + countingCopy[i] - 1, position - 1);
        }
    }
}
