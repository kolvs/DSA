package com.laychv.leetcode.array;

import java.util.HashMap;

import static com.laychv.common.PrintIntegerArray.integerArrayToString;
import static com.laychv.common.PrintIntegerArray.stringToIntegerArray;

class _1_TwoSum {
    public static void main(String[] args) {
        String line ="";
        int[] nums = stringToIntegerArray(line);
        int target = Integer.parseInt(line);
        int[] ret = new _1_TwoSum().twoSum(nums, target);
        String out = integerArrayToString(ret);
        System.out.print(out);

    }

    /**
     * 解法1：暴力法
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }


    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (hashMap.containsKey(temp)) {
                return new int[]{hashMap.get(temp), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}