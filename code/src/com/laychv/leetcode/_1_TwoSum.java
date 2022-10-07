package com.laychv.leetcode;

import java.util.HashMap;

import static com.laychv.common.PrintIntegerArray.integerArrayToString;
import static com.laychv.common.PrintIntegerArray.stringToIntegerArray;

/**
 * 1. 两数之和
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * https://leetcode.cn/problems/two-sum
 */
class _1_TwoSum {

    public static void main(String[] args) {
        String x = "[2,7,11,15]";
        int target = 9;
        System.out.println(integerArrayToString(twoSum(stringToIntegerArray(x), target)));
        System.out.println(integerArrayToString(twoSum2(stringToIntegerArray(x), target)));
    }

    // 暴力法
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // hash
    public static int[] twoSum2(int[] nums, int target) {
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