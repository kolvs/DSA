package com.laychv.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _844_BackspaceStringCompareTest {

    @Test
    void backspaceCompare() {
        String s = "ab#c";
        String t = "ad#c";
        boolean x = _844_BackspaceStringCompare.backspaceCompare(s, t);
        System.out.println(x);
        Assertions.assertTrue(x);
    }
}