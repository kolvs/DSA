package com.laychv.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _69_SqrtTest {

    @Test
    void mySqrt() {
        System.out.println(_69_Sqrt.mySqrt(8));
        System.out.println(_69_Sqrt.mySqrt(4));
    }

    @Test
    void mySqrt2() {
        int a = _69_Sqrt.mySqrt2(8);
        Assertions.assertEquals(2, a);
        System.out.println(a);
        int b = _69_Sqrt.mySqrt2(4);
        Assertions.assertEquals(2, b);
        System.out.println(b);
    }

    @Test
    void mySqrt3() {
        System.out.println(_69_Sqrt.mySqrt3(8));
        System.out.println(_69_Sqrt.mySqrt3(4));
    }
}