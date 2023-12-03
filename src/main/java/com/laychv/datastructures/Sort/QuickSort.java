package com.laychv.datastructures.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 * O(nlogn)
 * 不稳定
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] x = {11, 5, 8, 6, 3, 9, 2, 1, 4, 7};
        System.out.println(Arrays.toString(sort(x, 0, x.length - 1)));
        int[] y = {11, 5, 8, 6, 3, 9, 2, 1, 4, 7};
        quickSort(y);
        System.out.println(Arrays.toString(y));
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


    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public static void quickSort(int[] a, int start, int end) {
        // 如果区域内的数字少于 2 个，退出递归
        if (start >= end) return;
        // 将数组分区，并获得中间值的下标
        int middle = partition2(a, start, end);
        // 对左边区域快速排序
        quickSort(a, start, middle - 1);
        // 对右边区域快速排序
        quickSort(a, middle + 1, end);
    }

    public static int partition2(int[] arr, int start, int end) {
        // 取第一个数为基数
        int pivot = arr[start];
        // 从第二个数开始分区
        int left = start + 1;
        // 右边界
        int right = end;
        // left、right 相遇时退出循环
        while (left < right) {
            // 找到第一个大于基数的位置
            while (left < right && arr[left] <= pivot) left++;
            // 交换这两个数，使得左边分区都小于或等于基数，右边分区大于或等于基数
            if (left != right) {
                exchange(arr, left, right);
                right--;
            }
        }
        // 如果 left 和 right 相等，单独比较 arr[right] 和 pivot
        if (left == right && arr[right] > pivot) right--;
        // 将基数和中间数交换
        if (right != start) exchange(arr, start, right);
        // 返回中间值的下标
        return right;
    }

    private static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    // 把数组分为两半，返回分割中点
    public int[] quickSort3(int[] nums) {
        quickSort3(nums, 0, nums.length - 1);
        return nums;
    }

    // 快速排序
    public void quickSort3(int[] nums, int low, int high) {
        if (low >= high) return;
        // 左右两边有序
        int mid = partition3(nums, low, high);
        quickSort3(nums, low, mid - 1);
        quickSort3(nums, mid + 1, high);
    }

    public int partition3(int[] nums, int low, int high) {
        // 随机化
        Random rm = new Random();
        // [0, high]
        int index = rm.nextInt(high - low + 1) + low;
        swap(nums, index, low);

        // low变成一个洞
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] > pivot) high--;
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) low++;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }
}
