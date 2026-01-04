package com.laychv.leetcode;

import com.laychv.common.ListNode;

import static com.laychv.common.ListNode.listNodeToString;
import static com.laychv.common.ListNode.stringToListNode;

/**
 * 206. 反转链表 🟢
 * 反转一个单链表。
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * <p>
 * 输入：head = [1,2]
 * 输出：[2,1]
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * https://leetcode.cn/problems/reverse-linked-list/
 */
class _206_ReverseLinkedList {

    public static void main(String[] args) {
        String x = "[1,2,3,4,5]";
        System.out.println(listNodeToString(reverseList(stringToListNode(x))));
        System.out.println(listNodeToString(reverseList2(stringToListNode(x))));
        System.out.println(listNodeToString(reverseList4(stringToListNode(x))));
    }

    // 递归
    public static ListNode reverseList(ListNode head) {
        // 终止条件,当前或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        // 获取最后一个节点
        ListNode cur = reverseList(head.next);
        //
        head.next.next = head;
        //
        head.next = null;
        return cur;
    }

    // 迭代-双指针
    public static ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    // 迭代-双指针
    public static ListNode reverseList3(ListNode head) {
        ListNode prev = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // 虚拟头结点
    public static ListNode reverseList4(ListNode head) {
        // 创建虚拟头结点
        ListNode dum = new ListNode(0);
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = dum.next;
            dum.next = cur;
            cur = temp;
        }
        return dum.next;
    }
}
