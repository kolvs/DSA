package com.laychv.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1441. 用栈操作构建数组 🟠
 * <p>
 * 给你一个数组 target 和一个整数 n。每次迭代，需要从 list = { 1 , 2 , 3 ..., n } 中依次读取一个数字。
 * 请使用下述操作来构建目标数组 target ：
 * "Push"：从 list 中读取一个新元素， 并将其推入数组中。
 * "Pop"：删除数组中的最后一个元素。
 * 如果目标数组构建完成，就停止读取更多元素。
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 * 请返回构建目标数组所用的操作序列。如果存在多个可行方案，返回任一即可。
 * <p>
 * 输入：target = [1,3], n = 3
 * 输出：["Push","Push","Pop","Push"]
 * 解释：
 * 读取 1 并自动推入数组 -> [1]
 * 读取 2 并自动推入数组，然后删除它 -> [1]
 * 读取 3 并自动推入数组 -> [1,3]
 * <p>
 * 输入：target = [1,2,3], n = 3
 * 输出：["Push","Push","Push"]
 * <p>
 * 输入：target = [1,2], n = 4
 * 输出：["Push","Push"]
 * 解释：只需要读取前 2 个数字就可以停止。
 * <p>
 * 提示：
 * 1 <= target.length <= 100
 * 1 <= n <= 100
 * 1 <= target[i] <= n
 * target 严格递增
 * <p>
 * https://leetcode.cn/problems/build-an-array-with-stack-operations
 */
public class _1441_BuildAnArrayWithStackOperations {

    public static void main(String[] args) {
        int[] xt = {1, 2, 3};// 严格递增
        int x = 3;// 严格递增
        System.out.println(buildArray(xt, x));
        int[] yt = {1, 3};
        int y = 3;
        System.out.println(buildArray2(yt, y));
        int[] zt = {1, 2};
        int z = 4;
        System.out.println(buildArray3(zt, z));
    }

    // 模拟
    public static List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1, j = 0; i <= n && j < target.length; i++) {
            res.add("Push");
            if (target[j] != i) {
                res.add("Pop");
            } else {
                j++;
            }
        }
        return res;
    }

    public static List<String> buildArray2(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (sum >= target.length) break;
            if (i == target[sum]) {
                res.add("Push");
                sum++;
            } else {
                res.add("Push");
                res.add("Pop");
            }
        }
        return res;
    }

    /**
     * 模拟
     * 已知严格递增：1 - n
     * 规则：不在数组里的数字先push再pop，在数组的只需要push
     */
    public static List<String> buildArray3(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int sum = 1;
        for (int t : target) {
            while (sum != t) {
                sum++;
                res.add("Push");
                res.add("Pop");
            }
            res.add("Push");
            sum++;
        }
        return res;
    }

}
