package com.laychv.leetcode.string;

import java.util.ArrayList;
import java.util.List;

import static com.laychv.common.PrintIntegerArray.stringListToString;

class _1408_String_Matching_in_an_Array {

    public static void main(String[] args) {
        String[] words = new String[]{"mass", "as", "hero", "superhero"};
        List<String> ret = new _1408_String_Matching_in_an_Array().stringMatching(words);
        String out = stringListToString(ret);
        System.out.print(out);
    }

    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<String>();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j && words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}