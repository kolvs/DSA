package com.laychv.leetcode.string._1021_RemoveOutermostParentheses;

import com.eclipsesource.json.JsonArray;

import java.io.IOException;

public class MainClass {

    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            String s = stringToString(line);

        String s = "(()())(())";
        String ret = new Solution().removeOuterParentheses(s);
//        String ret2 = new Solution().removeOuterParentheses2(s);
//        String out = (ret);

        System.out.println(ret);
//        System.out.println(ret2);
//        }
    }
}