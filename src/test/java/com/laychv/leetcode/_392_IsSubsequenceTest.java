package com.laychv.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.laychv.leetcode._392_IsSubsequence.isSubsequence;
import static com.laychv.leetcode._392_IsSubsequence.isSubsequence2;

class _392_IsSubsequenceTest {

    @Test
    void test_isSubsequence() {
        Assertions.assertTrue(isSubsequence("abc", "ahbgdc"));
        Assertions.assertFalse(isSubsequence("axc", "ahbgdc"));
    }

    @Test
    void test_isSubsequence2() {
        Assertions.assertTrue(isSubsequence2("abc", "ahbgdc"));
        Assertions.assertFalse(isSubsequence2("axc", "ahbgdc"));
    }
}