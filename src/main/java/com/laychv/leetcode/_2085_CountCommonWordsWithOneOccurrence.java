package com.laychv.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/count-common-words-with-one-occurrence/description/?envType=daily-question&envId=2024-01-12
 */
public class _2085_CountCommonWordsWithOneOccurrence {

    public static void main(String[] args) {
        String[] w1 = {"leetcode", "is", "amazing", "as", "is"};
        String[] w2 = {"amazing", "leetcode", "is"};
        System.out.println(countWords(w1, w2));
    }

    /**
     * HashMap
     */
    public static int countWords(String[] words1, String[] words2) {
        int res = 0;

        Map<String, Integer> w1 = new HashMap<>();
        Map<String, Integer> w2 = new HashMap<>();

        for (String w : words1) {
            w1.put(w, w1.getOrDefault(w, 0) + 1);
        }
        for (String w : words2) {
            w2.put(w, w2.getOrDefault(w, 0) + 1);
        }

//        for (String w : w1.keySet()) {
//            if (w1.get(w) == 1 && w2.getOrDefault(w, 0) == 1) {
//                res++;
//            }
//        }

        for (String w : w2.keySet()) {
            if (w2.get(w) == 1 && w1.getOrDefault(w, 0) == 1) {
                res++;
            }
        }

        return res;
    }
}
