package com.laychv.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class _283_MoveZeroesTest {

    int[] x = {0, 1, 0, 3, 12};
    int[] y = {0, 0, 1};

    @Test
    void moveZeroes() {
        _283_MoveZeroes.moveZeroes(x);
        System.out.println(Arrays.toString(x));
    }

    @Test
    void moveZeroes2() {
        _283_MoveZeroes.moveZeroes2(y);
        System.out.println(Arrays.toString(y));
    }

    @Test
    void moveZeroes3() {
        _283_MoveZeroes.moveZeroes3(x);
        System.out.println(Arrays.toString(x));
    }
}