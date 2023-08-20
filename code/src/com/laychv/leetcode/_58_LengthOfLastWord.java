package com.laychv.leetcode;

import com.laychv.common.tools.CountTimes;

/**
 * 58. 最后一个单词的长度 🟢
 * <p>
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * <p>
 * 示例 2：
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 * <p>
 * 示例 3：
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为6的“joyboy”。
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 * https://leetcode.cn/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class _58_LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord2("Hell JJ"));
        System.out.println(lengthOfLastWord3("Hell JJ"));

        long stime = System.nanoTime();
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        long etime = System.nanoTime();
        System.out.printf("执行时长：%d 纳秒.", (etime - stime));
    }

    /***倒序遍历***/
    @CountTimes
    public static int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int length = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            length++;
            index--;
        }
        return length;
    }

    /***倒序遍历***/
    public static int lengthOfLastWord2(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') count++;
            if (count != 0 && s.charAt(i) == ' ') break;
        }
        return count;
    }

    /***Java-API***/
    public static int lengthOfLastWord3(String s) {
        String[] strArr = s.split(" ");
        return strArr[strArr.length - 1].length();
    }
}
