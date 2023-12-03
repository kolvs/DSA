package com.laychv.datastructures.Array;

/**
 * 数组迭代
 * while/for/do...while
 */
public class Iterator {

    public static void main(String[] args) {
        iteratorLeft2Right(new int[]{26, 51, 40, 58, 42, 76, 30, 48, 79, 91});
        iteratorRight2Left(new int[]{26, 51, 40, 58, 42, 76, 30, 48, 79, 91});
    }

    // 从左向右遍历
    private static void iteratorLeft2Right(int[] a) {

        // length = 10 , [0,10) / [0,9], 0~9
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        // 26,51,40,58,42,76,30,48,79,91
        int cnt1 = 0;
        for (int i = 0; i < a.length; i++) {
            System.out.print(i + ", ");
            cnt1++;
        }
        System.out.println("");
        for (int i : a) System.out.print(i + ",");
        System.out.println("");
        System.out.println("length:" + cnt1);
        System.out.println("");


        // length = 9 , [1,10) / [1,9], 1~9
        // 1, 2, 3, 4, 5, 6, 7, 8, 9,
        // 51,40,58,42,76,30,48,79,91,
        int cnt2 = 0;
        for (int i = 1; i < a.length; i++) {
            System.out.print(i + ", ");
            cnt2++;
        }
        System.out.println("");
        for (int i = 1; i < a.length; i++) System.out.print(a[i] + ",");
        System.out.println("");
        System.out.print("length:" + cnt2);
        System.out.println("");


        // length = 9 , [0,9-1) / [0,8], 0~8
        //0, 1, 2, 3, 4, 5, 6, 7, 8,
        //26,51,40,58,42,76,30,48,79,
        int cnt3 = 0;
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(i + ", ");
            cnt3++;
        }
        System.out.println("");
        for (int i = 0; i < a.length - 1; i++) System.out.print(a[i] + ",");
        System.out.println("");
        System.out.println("length:" + cnt3);
        System.out.println("");
    }

    // 从右向左遍历
    private static void iteratorRight2Left(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            //91,79,48,30,76,42,58,40,51,26
            System.out.print(a[i] + ",");
        }
        System.out.println("");
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.print(i + ", ");
        }
    }


}
