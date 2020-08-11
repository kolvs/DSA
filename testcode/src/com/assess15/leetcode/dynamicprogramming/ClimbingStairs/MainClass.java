package com.assess15.leetcode.dynamicprogramming.ClimbingStairs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 */
public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            int ret = new Solution4().climbStairs(n);
            String out = String.valueOf(ret);
            System.out.print(out);
        }
    }
}