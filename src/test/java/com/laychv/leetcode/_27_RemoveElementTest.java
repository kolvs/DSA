package com.laychv.leetcode;

import org.junit.jupiter.api.Test;

import static com.laychv.common.PrintIntegerArray.integerArrayToString;

class _27_RemoveElementTest {

    int[] a = {3, 2, 2, 3};
    int av = 3;

    int[] y = {0, 1, 2, 2, 3, 0, 4, 2};
    int yv = 2;

    @Test
    void removeElement() {
        System.out.println(_27_RemoveElement.removeElement(a, av));
        System.out.println(integerArrayToString(a, _27_RemoveElement.removeElement(a, av) - 1));
    }

    @Test
    void removeElement1() {
        System.out.println(_27_RemoveElement.removeElement1(a, av));
        System.out.println(integerArrayToString(a, _27_RemoveElement.removeElement1(a, av) - 1));
    }

    @Test
    void removeElement2() {
        System.out.println(_27_RemoveElement.removeElement2(y, yv));
        System.out.println(integerArrayToString(y, _27_RemoveElement.removeElement2(y, yv) - 2));
    }

    @Test
    void removeElement3() {
        System.out.println(_27_RemoveElement.removeElement3(y, yv));
        System.out.println(integerArrayToString(y, _27_RemoveElement.removeElement3(y, yv) - 2));
    }
}