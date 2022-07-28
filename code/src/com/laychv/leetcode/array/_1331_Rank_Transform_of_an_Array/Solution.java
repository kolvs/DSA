package com.laychv.leetcode.array._1331_Rank_Transform_of_an_Array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * sort + hash
 */
public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        int[] clone = arr.clone();
        Arrays.sort(clone);
        int length = clone.length;
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : clone) {
            if (!map.containsKey(i)) {
                map.put(i, ++index);
            }
        }
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}
