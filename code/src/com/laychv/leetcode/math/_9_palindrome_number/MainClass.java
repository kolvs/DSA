package com.laychv.leetcode.math._9_palindrome_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);
            boolean ret = new Solution().isPalindrome(x);
            String out = booleanToString(ret);
            System.out.print(out);
        }
    }
}
