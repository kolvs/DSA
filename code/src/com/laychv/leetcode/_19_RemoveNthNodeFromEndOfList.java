package com.laychv.leetcode;

import com.laychv.common.SingleNode;

import static com.laychv.common.PrintSingleNode.listNodeToString;
import static com.laychv.common.PrintSingleNode.stringToListNode;

/**
 * 19. 删除链表的倒数第N个节点
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

    static public SingleNode removeNthFromEnd(SingleNode head, int n) {
        SingleNode dummy = new SingleNode(0);
        dummy.next = head;
        SingleNode first = dummy;
        SingleNode second = dummy;
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