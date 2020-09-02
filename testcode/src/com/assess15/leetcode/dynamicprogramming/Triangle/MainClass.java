package com.assess15.leetcode.dynamicprogramming.Triangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
 *
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MainClass {
//    private static List<Integer> stringToIntegerList(String input) {
//      JsonArray jsonArray = JsonArray.readFrom(input);
//      List<Integer> arr = new ArrayList<>(jsonArray.size());
//      for (int i = 0; i < jsonArray.size(); i++) {
//        arr.add(jsonArray.get(i).asInt());
//      }
//      return arr;
//    }
//
//    public static List<List<Integer>> stringToInt2dList(String input) {
//        JsonArray jsonArray = JsonArray.readFrom(input);
//        if (jsonArray.size() == 0) {
//          return new ArrayList<List<Integer>>();
//        }
//
//        List<List<Integer>> list = new ArrayList<>(jsonArray.size());
//        for (int i = 0; i < jsonArray.size(); i++) {
//          JsonArray cols = jsonArray.get(i).asArray();
//          list.add(stringToIntegerList(cols.toString()));
//        }
//        return list;
//    }
//
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
//            List<List<Integer>> triangle = stringToInt2dList(line);
//            int ret = new Solution1().minimumTotal(triangle);
//            String out = String.valueOf(ret);
//            System.out.print(out);
        }
    }
}