package com.laychv.leetcode;

/**
 * 344.反转字符串
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * <p>
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 都是 ASCII 码表中的可打印字符
 * <p>
 * https://leetcode.cn/problems/reverse-string
 */
public class _344_ReverseString {

    public static void main(String[] args) {
        String x = "hello";
        char[] chars = x.toCharArray();
        reverseString(chars);
        System.out.println(chars);
    }

    // 双指针
    public static void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left < right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

}