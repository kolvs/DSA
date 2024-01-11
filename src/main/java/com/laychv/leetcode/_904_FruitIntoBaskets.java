package com.laychv.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 904. 水果成篮 🟠
 * <p>
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。
 * 每采摘一次，你将会向右移动到下一棵树，并继续采摘。一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 * <p>
 * 输入：fruits = [1,2,1]
 * 输出：3
 * 解释：可以采摘全部 3 棵树。
 * <p>
 * 输入：fruits = [0,1,2,2]
 * 输出：3
 * 解释：可以采摘 [1,2,2] 这三棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
 * <p>
 * 输入：fruits = [1,2,3,2,2]
 * 输出：4
 * 解释：可以采摘 [2,3,2,2] 这四棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
 * <p>
 * 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
 * 输出：5
 * 解释：可以采摘 [1,2,1,1,2] 这五棵树。
 * <p>
 * 提示：
 * 1 <= fruits.length <= 10^5
 * 0 <= fruits[i] < fruits.length
 * <p>
 * https://leetcode.cn/problems/fruit-into-baskets/
 */
public class _904_FruitIntoBaskets {

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1, 2, 1}));
        System.out.println(totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println(totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));

        System.out.println(totalFruit2(new int[]{1, 2, 3, 2, 2}));
    }

    /**
     * Sliding Window + Map
     * [0,1,2,2]
     * [0],[1] max(2) unsuitable
     * [1],[2,2] max(3) suitable
     */
    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int right = 0, left = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    /**
     * 滑动窗口
     */
    public static int totalFruit2(int[] fruits) {
        int res = 0;
        int[] cnt = new int[fruits.length];

        for (int i = 0, j = 0, sum = 0; i < fruits.length; i++) {
            if (++cnt[fruits[i]] == 1) {
                sum++;
            }
            while (sum > 2) {
                if (--cnt[fruits[j++]] == 0) {
                    sum--;
                }
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
