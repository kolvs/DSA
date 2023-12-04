package com.laychv.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II 🟢
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class _119_PascalsTriangle_II {

    // 递归
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> curRow = new ArrayList<>();
        curRow.add(1);
        if (rowIndex == 0) return curRow;

        List<Integer> preRow = getRow(rowIndex - 1);
        for (int i = 0; i < preRow.size()- 1; i++) {
            curRow.add(preRow.get(i) + preRow.get(i+1));
        }
        curRow.add(1);
        return curRow;
    }
}
