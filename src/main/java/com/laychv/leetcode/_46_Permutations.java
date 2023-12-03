package com.laychv.leetcode;

import java.util.ArrayList;
import java.util.List;

import static com.laychv.common.PrintIntegerArray.int2dListToString;

/**
 * 46.全排列 🟠
 * <p>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * https://leetcode.cn/problems/permutations/
 */
public class _46_Permutations {

    public static void main(String[] args) {
        int[] x = {1, 2, 3};
        int[] y = {0,1};
        System.out.println(int2dListToString(permute(x)));
        System.out.println(int2dListToString(permute(y)));
    }

    public static List<List<Integer>> permute(int[] nums) {
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
    public static void backtrack(List<List<Integer>> res, List<Integer> item, int[] nums) {
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
