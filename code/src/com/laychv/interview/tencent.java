package com.laychv.interview;

/**
 * 一道面试题:
 * 数组全数列
 */

public class tencent {

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4};
        int left = 0;
        int right = list.length - 1;
        solve(list, left, right);
    }

    private static void solve(int[] list, int left, int right) {
        if (left == right) {
            for (int i = 0; i < list.length; i++) {
                System.out.print(list[i]);
            }
            System.out.println();
        } else {
            for (int i = left; i <= right; i++) {
                swap(list, left, i);
                solve(list, left + 1, right);
                swap(list, left, i);
            }
        }
    }

    private static void swap(int[] list, int left, int right) {
        int temp = list[left];
        list[left] = list[right];
        list[right] = temp;
    }

}
