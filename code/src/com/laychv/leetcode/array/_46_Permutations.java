package com.laychv.leetcode.array;

import java.util.ArrayList;
import java.util.List;

import static com.laychv.common.PrintIntegerArray.int2dListToString;
import static com.laychv.common.PrintIntegerArray.stringToIntegerArray;

/**
 * 全排列
 */
public class _46_Permutations {

    public static void main(String[] args) {
        String line = "";
        int[] nums = stringToIntegerArray(line);
        List<List<Integer>> ret = new _46_Permutations().permute(nums);
        String out = int2dListToString(ret);
        System.out.print(out);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        backtrack(res, item, nums);
        return res;
    }

    /**
     * 回溯算法核心
     * for + 递归
     *
     * @param res  结果[[],[]]
     * @param item 元素[]
     * @param nums 原始数据
     */
    public void backtrack(List<List<Integer>> res, List<Integer> item, int[] nums) {
        if (item.size() == nums.length) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int num : nums) {
            if (!item.contains(num)) {
                item.add(num);
                backtrack(res, item, nums);
                item.remove(item.size() - 1);
            }
        }
    }
}
