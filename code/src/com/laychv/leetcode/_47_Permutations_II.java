package com.laychv.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.laychv.common.PrintIntegerArray.int2dListToString;

/**
 * 47. 全排列 II 🟡
 * <p>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：[[1,1,2],[1,2,1],[2,1,1]]
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 输入：nums = [3,3,0,3]
 * 输出：[[0,3,3,3],[3,0,3,3],[3,3,0,3],[3,3,3,0]]
 * <p>
 * https://leetcode.cn/problems/permutations-ii/
 */
public class _47_Permutations_II {

    static boolean[] visited;

    public static void main(String[] args) {
        int[] x = {1, 1, 2};
        System.out.println(int2dListToString(permuteUnique(x)));
        int[] y = {3, 3, 0, 3};
        System.out.println(int2dListToString(permuteUnique(y)));
    }

    /**
     * 回溯
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrace(nums, 0, res, item);
        return res;
    }

    private static void backtrace(int[] nums, int idx, List<List<Integer>> res, List<Integer> item) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            item.add(nums[i]);
            visited[i] = true;
            backtrace(nums, idx + 1, res, item);
            visited[i] = false;
            item.remove(idx);
        }
    }
}
