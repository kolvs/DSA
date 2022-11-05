package com.laychv.leetcode;

/**
 * 754. 到达终点数字 🟠
 * <p>
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * 你可以做一些数量的移动 numMoves :
 * 每次你可以选择向左或向右移动。
 * 第 i 次移动（从  i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
 * 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。
 * <p>
 * 输入: target = 2
 * 输出: 3
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 -1 。
 * 第三次移动，从 -1 到 2 。
 * <p>
 * 输入: target = 3
 * 输出: 2
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 3 。
 * <p>
 * 提示:
 * <p>
 * -10^9 <= target <= 10^9
 * target != 0
 * <p>
 * https://leetcode.cn/problems/reach-a-number/
 */
public class _754_ReachANumber {

    public static void main(String[] args) {
        System.out.println("3->:" + reachNumber(2));
        System.out.println("2->:" + reachNumber2(3));
    }

    public static int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;

        while (target > 0) {
            k++;
            target -= k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }

    public static int reachNumber2(int target) {
        int res = 0;
        int num = 0;
        int t = Math.abs(target);

        while (num < t || (num - t) % 2 != 0) {
            num += ++res;
        }
        return res;
    }
}