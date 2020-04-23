package com.assess15.algorithm.array.MergeSortedArray;

public class tet {
    public static void main(String[] args) {
        int[] fun = {0, 1, 2, 3, 4, 5, 6};
        int[] fun1 = {0, 1, 2, 3, 4, 5, 6};
        /**
         * src:源数组
         * srcPos:源数组要复制的起始位置；
         * dest:目的数组；
         * destPos:目的数组放置的起始位置；
         * length:复制的长度。
         */
        System.arraycopy(fun, 0, fun1, 3, 3);
        for (int i : fun1) {
            System.out.print(i);
        }
    }
}
