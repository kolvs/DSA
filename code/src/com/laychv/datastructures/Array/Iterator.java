package com.laychv.datastructures.Array;

/**
 * 数组迭代
 * while/for/do...while
 */
public class Iterator {

    public static void main(String[] args) {
        iterator(new int[]{26, 51, 40, 58, 42, 76, 30, 48, 79, 91});
    }

    private static void iterator(int[] a) {
        // length = 10 , [0,10) / [0,9], 0~9
        int cnt1 = 0;
        for (int i = 0; i < a.length; i++) {
            System.out.print(i + ":");
            System.out.println(a[i]);
            cnt1++;
        }
        System.out.print("length:" + cnt1);
        System.out.println("");


        // length = 9 , [1,10) / [1,9], 1~9
        int cnt2 = 0;
        for (int i = 1; i < a.length; i++) {
            System.out.print(i + ":");
            System.out.println(a[i]);
            cnt2++;
        }
        System.out.print("length:" + cnt2);
        System.out.println("");


        // length = 9 , [0,9-1) / [0,8], 0~8
        int cnt3 = 0;
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(i + ":");
            System.out.println(a[i]);
            cnt3++;
        }
        System.out.print("length:" + cnt3);
        System.out.println("");
    }
}
