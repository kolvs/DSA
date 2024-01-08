package com.laychv.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class _977_SquaresOfASortedArrayTest {

    int[] x = {-4, -1, 0, 3, 10};
    int[] y = {-7, -3, 2, 3, 11};

    @Test
    void sortedSquares() {
        System.out.println(Arrays.toString(_977_SquaresOfASortedArray.sortedSquares(x)));
    }

    @Test
    void sortedSquares2() {
        System.out.println(Arrays.toString(_977_SquaresOfASortedArray.sortedSquares2(y)));
    }

    @Test
    void sortedSquares3() {
        System.out.println(Arrays.toString(_977_SquaresOfASortedArray.sortedSquares3(y)));
    }

    @Test
    void sortedSquares4() {
        System.out.println(Arrays.toString(_977_SquaresOfASortedArray.sortedSquares4(y)));
    }

    @Test
    void sortedSquares5() {
        System.out.println(Arrays.toString(_977_SquaresOfASortedArray.sortedSquares5(y)));
    }
}