package com.laychv.leetcode.array._46_Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class Solution {
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
