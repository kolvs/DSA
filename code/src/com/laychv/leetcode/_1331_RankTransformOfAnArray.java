package com.laychv.leetcode;

import java.util.Arrays;
import java.util.HashMap;

import static com.laychv.common.PrintIntegerArray.integerArrayToString;

/**
 * 1331. 数组序号转换 🟢
 * <p>
 * 给你一个整数数组arr ，请你将数组中的每个元素替换为它们排序后的序号。
 * <p>
 * 序号代表了一个元素有多大。序号编号的规则如下：
 * <p>
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 * <p>
 * 输入：arr = [40,10,20,30]
 * 输出：[4,1,2,3]
 * 解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
 * <p>
 * 输入：arr = [100,100,100]
 * 输出：[1,1,1]
 * 解释：所有元素有相同的序号。
 * <p>
 * 输入：arr = [37,12,28,9,100,56,80,5,12]
 * 输出：[5,3,4,2,8,6,7,1,3]
 * <p>
 * https://leetcode.cn/problems/rank-transform-of-an-array
 */

public class _1331_RankTransformOfAnArray {

    public static void main(String[] args) {
        int[] x = {40, 10, 20, 30};
        System.out.print(integerArrayToString(arrayRankTransform(x)));
    }

    /**
     * sort + hash
     */
    public static int[] arrayRankTransform(int[] arr) {
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
