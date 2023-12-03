package com.laychv.leetcode;

import java.util.Arrays;

/**
 * 1700. 无法吃午餐的学生数量 🟢
 * <p>
 * 学校的自助午餐提供圆形和方形的三明治，分别用数字0和1表示。所有学生站在一个队列里，每个学生要么喜欢圆形的要么喜欢方形的。
 * 餐厅里三明治的数量与学生的数量相同。所有三明治都放在一个栈里，每一轮：
 * 如果队列最前面的学生喜欢栈顶的三明治，那么会拿走它并离开队列。
 * 否则，这名学生会放弃这个三明治并回到队列的尾部。这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。
 * 给你两个整数数组students 和sandwiches，其中sandwiches[i]是栈里面第i个三明治的类型（i = 0是栈的顶部），
 * students[j]是初始队列里第j名学生对三明治的喜好（j = 0是队列的最开始位置）。请你返回无法吃午餐的学生数量。
 * <p>
 * 输入：students = [1,1,0,0], sandwiches = [0,1,0,1]
 * 输出：0
 * 解释：
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [1,0,0,1]。
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [0,0,1,1]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [0,1,1]，三明治栈为 sandwiches = [1,0,1]。
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [1,1,0]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [1,0]，三明治栈为 sandwiches = [0,1]。
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [0,1]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [1]，三明治栈为 sandwiches = [1]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = []，三明治栈为 sandwiches = []。
 * 所以所有学生都有三明治吃。
 * <p>
 * 输入：students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
 * 输出：3
 * <p>
 * 提示：
 * 1 <= students.length, sandwiches.length <= 100
 * students.length == sandwiches.length
 * sandwiches[i]要么是0，要么是1。
 * students[i]要么是0，要么是1。
 * <p>
 * https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch
 */
public class _1700_NumberOfStudentsUnableToEatLunch {

    public static void main(String[] args) {
        System.out.println("0-" + countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
        System.out.println("0-" + countStudents2(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
        System.out.println("3-" + countStudents3(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        // count[0 or 1] 分别代表吃 0 和吃 1的学生数量
        int[] count = new int[2];

        for (int student : students) {
            count[student]++;
        }

        // 遍历三明治栈，若栈顶的三明治无法被取走，则剩下的人都吃不上了
        for (int sandwich : sandwiches) {
            if (count[sandwich] == 0) {
                // 两种喜好加起来就是剩下的学生数量
                return count[0] + count[1];
            }
            count[sandwich]--;
        }

        return 0;
    }

    public static int countStudents2(int[] students, int[] sandwiches) {
        int[] cnt = new int[2];
        for (int v : students) {
            ++cnt[v];
        }

        for (int v : sandwiches) {
            if (cnt[v]-- == 0) {
                return cnt[v ^ 1];
            }
        }
        return 0;
    }

    public static int countStudents3(int[] students, int[] sandwiches) {
        int s1 = Arrays.stream(students).sum();// 圆形三明治
        int s0 = students.length - s1;// 方形三明治
        for (int sandwich : sandwiches) {
            if (sandwich == 0 && s0 > 0) {
                s0--;
            } else if (sandwich == 1 && s1 > 0) {
                s1--;
            } else {
                break;
            }
        }
        return s0 + s1;
    }
}
