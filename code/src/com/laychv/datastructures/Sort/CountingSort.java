package com.laychv.datastructures.Sort;

import java.util.Arrays;

/**
 * 计数排序
 * O(n)
 */
public class CountingSort {

    public static void main(String[] args) {
        countingSort(TestSample.x);
        System.out.println(Arrays.toString(TestSample.x));
    }

    public static void countingSort(int[] arr) {
        // 判空及防止数组越界
        if (arr == null || arr.length <= 1) return;
        // 找到最大值，最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            else if (arr[i] < min) min = arr[i];
        }
        // 确定计数范围
        int range = max - min + 1;
        // 建立长度为 range 的数组，下标 0~range-1 对应数字 min~max
        int[] counting = new int[range];
        // 遍历 arr 中的每个元素
        for (int element : arr) {
            // 将每个整数出现的次数统计到计数数组中对应下标的位置，这里需要将每个元素减去 min，才能映射到 0～range-1 范围内
            counting[element - min]++;
        }
        // 记录前面比自己小的数字的总数
        int preCounts = 0;
        for (int i = 0; i < range; i++) {
            // 当前的数字比下一个数字小，累计到 preCounts 中
            preCounts += counting[i];
            // 将 counting 计算成当前数字在结果中的起始下标位置。位置 = 前面比自己小的数字的总数。
            counting[i] = preCounts - counting[i];
        }
        int[] result = new int[arr.length];
        for (int element : arr) {
            // counting[element - min] 表示此元素在结果数组中的下标
            result[counting[element - min]] = element;
            // 更新 counting[element - min]，指向此元素的下一个下标
            counting[element - min]++;
        }
        // 将结果赋值回 arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }
}
