package com.laychv.leetcode.stack.TrappingRainWater;

import java.io.IOException;

/**
 * 42. 接雨水
 */

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int[] height = stringToIntegerArray(line);
//            int ret = new Solution().trap(height);
//            String out = String.valueOf(ret);
//            System.out.print(out);
//        }

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] height = {2,0,2,3};
        int ret = new Solution1().trap(height);
        String out = String.valueOf(ret);
        System.out.print(out);
    }
}