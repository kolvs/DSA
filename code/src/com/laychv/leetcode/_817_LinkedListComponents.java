package com.laychv.leetcode;

import com.laychv.common.ListNode;

import java.util.HashSet;
import java.util.Set;

import static com.laychv.common.PrintListNode.stringToListNode;

/**
 * 817. 链表组件 🟠
 * <p>
 * 给定链表头结点head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表nums，该列表是上述链表中整型值的一个子集。
 * 返回列表nums中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表nums中）构成的集合。
 * <p>
 * 输入: head = [0,1,2,3], nums = [0,1,3]
 * 输出: 2
 * 解释: 链表中,0 和 1 是相连接的，且 nums 中不包含 2，所以 [0, 1] 是 nums 的一个组件，同理 [3] 也是一个组件，故返回 2。
 * <p>
 * 输入: head = [0,1,2,3,4], nums = [0,3,1,4]
 * 输出: 2
 * 解释: 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 * <p>
 * 输入: head = [1,2,0,4,3],nums = [3,4,0,2,1]
 * 输出: 1
 * <p>
 * https://leetcode.cn/problems/linked-list-components
 */
public class _817_LinkedListComponents {

    public static void main(String[] args) {
        String a = "[0,1,2,3]";
        int[] x = {0, 1, 3};
        System.out.println(numComponents(stringToListNode(a), x));
        String b = "[1,2,0,4,3]";
        int[] y = {3, 4, 0, 2, 1};
        System.out.println(numComponents2(stringToListNode(b), y));
    }

    /**
     * iterator + set
     */
    public static int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        boolean inSet = false;

        for (int n : nums) {
            set.add(n);
        }

        while (head != null) {
            if (set.contains(head.val)) {
                if (!inSet) {
                    inSet = true;
                    res++;
                }
            } else {
                inSet = false;
            }
            head = head.next;
        }
        return res;
    }

    /**
     * iterator + set
     */
    public static int numComponents2(ListNode head, int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        while (head != null) {
            if (set.contains(head.val)) {
                while (head != null && set.contains(head.val)) head = head.next;
                res++;
            } else {
                head = head.next;
            }
        }

        return res;
    }
}
