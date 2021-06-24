package com.laychv.leetcode.math._7_reverse_integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            int ret = new Solution().reverse(x);

            String out = String.valueOf(ret);

            System.out.println(out);
            System.out.println(Integer.MAX_VALUE);
            System.out.println(Integer.MAX_VALUE / 10);
            System.out.println(Integer.MIN_VALUE);
            System.out.println(Integer.MIN_VALUE / 10);
        }
    }
}