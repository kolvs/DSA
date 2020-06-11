package com.assess15.leetcode.search.SearchInsertPosition;

import java.io.IOException;

/**
 * 35. 搜索插入位置
 * 和二分查找模版代码基本一致
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
//            int[] nums = stringToIntegerArray(line);
//            line = in.readLine();
//            int target = Integer.parseInt(line);
//            int ret = new Solution().searchInsert(nums, target);
//            String out = String.valueOf(ret);
//            System.out.print(out);
//        }

        int[] nums = {1, 3, 5, 6};
        int target = 2;

        int ret = new Solution().searchInsert(nums, target);
        System.out.print(ret);
    }
}