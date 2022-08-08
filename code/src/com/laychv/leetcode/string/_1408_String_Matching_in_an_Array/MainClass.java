package com.laychv.leetcode.string._1408_String_Matching_in_an_Array;

import com.eclipsesource.json.JsonArray;

import java.io.IOException;
import java.util.List;

public class MainClass {
    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            String[] words = stringToStringArray(line);
//            List<String> ret = new Solution().stringMatching(words);
//            String out = stringListToString(ret);
//            System.out.print(out);
//        }

        // ["mass","as","hero","superhero"]
        String[] words = new String[]{"mass", "as", "hero", "superhero"};
        List<String> ret = new Solution().stringMatching(words);
        String out = stringListToString(ret);
        System.out.print(out);
    }
}