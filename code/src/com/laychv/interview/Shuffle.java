package com.laychv.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 洗牌算法
 * <p>
 * 从长度为m的int数组中随机取出n个元素，每次取的元素都是之前未取过的
 * <p>
 * Knuth大家应该比较熟悉，《The Art of Computer Programming》
 * <p>
 * https://blog.csdn.net/lxk_1993/article/details/109818167
 */
public class Shuffle {

    public static void main(String[] args) {
        System.out.println(shuffle(5, 2));
    }

    private static int shuffle(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        for (int i = 0; i < m; i++) {
            int t = (int) (list.size() * Math.random());
            System.out.println(list.remove(t));
            return list.remove(t);
        }
        return list.size();
    }
}
