package com.laychv.leetcode;

/**
 * 777. 在LR字符串中交换相邻字符 🟠
 * <p>
 * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
 * <p>
 * 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * 输出: True
 * 解释:
 * 我们可以通过以下几步将start转换成end:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * <p>
 * https://leetcode.cn/problems/swap-adjacent-in-lr-string
 */
public class _777_SwapAdjacentInLRString {

    public static void main(String[] args) {
        String s = "RXXLRXRXL";
        String e = "XRLXXRRLX";
        System.out.println(canTransform(s, e));
    }

    // two pointers
    public static boolean canTransform(String start, String end) {
        int n = start.length(), s = 0, e = 0;
        while (s < n || e < n) {
            while (s < n && start.charAt(s) == 'X') s++;
            while (e < n && end.charAt(e) == 'X') e++;
            if (s == n || e == n) return s == e;
            if (start.charAt(s) != end.charAt(e)) return false;
            if (start.charAt(s) == 'L' && s < e) return false;
            if (start.charAt(s) == 'R' && s > e) return false;
            s++;
            e++;
        }
        return s == e;
    }
}
