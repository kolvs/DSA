package com.laychv.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.laychv.leetcode._459_RepeatedSubstringPattern.*;

class _459_RepeatedSubstringPatternTest {

    @Test
    void test_repeatedSubstringPattern() {
        Assertions.assertTrue(repeatedSubstringPattern("abab"));
        Assertions.assertFalse(repeatedSubstringPattern("aba"));
        Assertions.assertTrue(repeatedSubstringPattern("abcabcabcabc"));
    }

    @Test
    void test_repeatedSubstringPattern2() {
        Assertions.assertTrue(repeatedSubstringPattern2("abab"));
        Assertions.assertFalse(repeatedSubstringPattern2("aba"));
        Assertions.assertTrue(repeatedSubstringPattern2("abcabcabcabc"));
    }

    @Test
    void test_repeatedSubstringPattern3() {
        Assertions.assertTrue(repeatedSubstringPattern3("abab"));
        Assertions.assertFalse(repeatedSubstringPattern3("aba"));
        Assertions.assertTrue(repeatedSubstringPattern3("abcabcabcabc"));
    }
}