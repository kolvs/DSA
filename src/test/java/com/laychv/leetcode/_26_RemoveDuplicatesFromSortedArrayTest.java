package com.laychv.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _26_RemoveDuplicatesFromSortedArrayTest {

    int[] as = new int[]{1, 1, 2};
    int[] bs = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

    @Test
    void removeDuplicates() {
        int i = _26_RemoveDuplicatesFromSortedArray.removeDuplicates(as);
        System.out.println(i);
        Assertions.assertEquals(2, i);
    }

    @Test
    void removeDuplicates0() {
        int i = _26_RemoveDuplicatesFromSortedArray.removeDuplicates0(as);
        System.out.println(i);
        Assertions.assertEquals(2, i);
    }

    @Test
    void removeDuplicates2() {
        int i = _26_RemoveDuplicatesFromSortedArray.removeDuplicates2(bs);
        System.out.println(i);
        Assertions.assertEquals(5, i);
    }

    @Test
    void removeDuplicates3() {
        int i = _26_RemoveDuplicatesFromSortedArray.removeDuplicates3(bs);
        System.out.println(i);
        Assertions.assertEquals(5, i);
    }

    @Test
    void removeDuplicates4() {
        int i = _26_RemoveDuplicatesFromSortedArray.removeDuplicates4(bs);
        System.out.println(i);
        Assertions.assertEquals(5, i);
    }
}