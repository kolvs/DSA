package com.laychv.leetcode;

import com.laychv.common.ListNode;

import static com.laychv.common.PrintListNode.listNodeToString;
import static com.laychv.common.PrintListNode.stringToListNode;

/**
 * 19. 删除链表的倒数第N个节点 🟡
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
class _19_RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        String x = "[1,2,3,4,5]";
        int n = 2;
        System.out.print(listNodeToString(removeNthFromEnd(stringToListNode(x), n)));
    }

    static public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}