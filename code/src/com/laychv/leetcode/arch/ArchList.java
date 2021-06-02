package com.laychv.leetcode.arch;

/**
 * 顺序表
 * 迭代框架
 * 迭代访问
 */
public class ArchList {
    private static void loop(int[] arr) {
        // 普通for循环 取值
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            System.out.print(a);
        }
        System.out.println();

        // 增强for循环
        for (int ar : arr) {
            System.out.print(ar);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {1, 8, 3, 4, 9, 6};
        loop(a);
    }
}
