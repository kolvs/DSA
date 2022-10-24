package com.laychv.leetcode;

import com.laychv.common.ListNode;

import static com.laychv.common.ListNode.listNodeToString;
import static com.laychv.common.ListNode.stringToListNode;

/**
 * 2. 两数相加 🟠
 * <p>
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * https://leetcode.cn/problems/add-two-numbers/
 */
public class _2_AddTwoNumbers {

    /**
     * 给定2个逆序链表，让两个链表中数值相加，然后求和
     * 考点：
     * 数值相加后的进位问题；
     * 虚拟头结点的使用；
     * 10进制相加；
     */
    public static void main(String[] args) {
        String x = "[2,4,3]";
        String y = "[5,6,4]";
        System.out.println(listNodeToString(addTwoNumbers(stringToListNode(x), stringToListNode(y))));
        String a = "[9,9,9,9,9,9,9]";
        String b = "[9,9,9,9]";
        System.out.println(listNodeToString(addTwoNumbers2(stringToListNode(a), stringToListNode(b))));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        // 双指针
        ListNode n1 = l1;
        ListNode n2 = l2;
        // dummy
        ListNode dummy = new ListNode(-1);
        // temp指向dummy结点
        ListNode temp = dummy;
        // 进位
        int carry = 0;
        while (n1 != null || n2 != null || carry > 0) {
            int val = carry;
            if (n1 != null) {
                val += n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                val += n2.val;
                n2 = n2.next;
            }
            carry = val / 10;
            val = val % 10;
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        return dummy.next;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            temp.next = new ListNode(sum);
            temp = temp.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) {
            temp.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
