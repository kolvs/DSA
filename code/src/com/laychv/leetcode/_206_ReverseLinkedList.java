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
        System.out.print(listNodeToString(reverseList(stringToListNode(x))));
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

    // 迭代
    public ListNode reverseList2(ListNode head) {
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

    public ListNode reverseList3(ListNode head) {
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
}
