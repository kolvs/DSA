package com.laychv.leetcode.math._136_single_number;

public class Test {
    public static void main(String[] args) {
        int a = 2;
        int b = 2;
        int c = 1;
        int d = 3;
        System.out.println(a ^ b ^ c ^ d);
        String sa = Integer.toBinaryString(a);
        String sb = Integer.toBinaryString(b);
        String sc = Integer.toBinaryString(c);
        String sd = Integer.toBinaryString(d);
        System.out.println(sa);
        System.out.println(sb);
        System.out.println(sc);
        System.out.println(sd);
    }
}
