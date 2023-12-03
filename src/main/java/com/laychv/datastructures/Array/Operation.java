package com.laychv.datastructures.Array;

import java.util.Arrays;

/**
 * Array CRUD
 */
public class Operation {

    public static void main(String[] args) {
        create();
        read();
        update();
        insert();
        delete();
    }

    private static void create() {
        int[] a = new int[]{1, 2, 3};
        int[] b = {1, 2, 3};
        int[] c = new int[3];

        char[] x = new char[]{'a', 'b', 'c'};
        String[] y = {"a", "b", "c"};
    }

    private static void read() {
        int[] array = new int[]{3, 1, 2, 5, 4, 9, 7, 2};
        // 输出数组中下标为3的元素
        System.out.println(array[3]);
    }

    private static void update() {
        int[] array = new int[]{3, 1, 2, 5, 4, 9, 7, 2};
        // 给数组下标为5的元素赋值
        array[5] = 10;
        // 输出数组中下标为5的元素
        System.out.println(array[5]);
    }

    private static void insert() {
        int[] a = new int[10];
        a[0] = 3;
        a[1] = 1;
        a[2] = 2;
        a[3] = 5;
        a[4] = 4;
        a[5] = 9;
        a[6] = 7;
        a[7] = 2;
        int index = 2;
        int element = 110;
        //从右向左循环，将元素逐个向右挪1位
        for (int i = a.length - 1; i >= index; i--) {
            a[i] = a[i - 1];
        }
        //腾出的位置放入新元素
        a[index] = element;

        System.out.println(Arrays.toString(a));
    }

    private static void delete() {
        int index = 3;
        int[] a = new int[]{3, 1, 2, 5, 4, 9, 7, 2};

        for (int i = index; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }
        a[a.length - 1] = 0;

        System.out.println(Arrays.toString(a));
    }
}