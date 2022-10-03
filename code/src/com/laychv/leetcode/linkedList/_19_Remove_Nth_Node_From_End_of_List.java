package com.laychv.leetcode.linkedList;

import com.laychv.common.SingleNode;

import java.io.IOException;

import static com.laychv.common.PrintSingleNode.listNodeToString;
import static com.laychv.common.PrintSingleNode.stringToListNode;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
class _19_Remove_Nth_Node_From_End_of_List {

    public static void main(String[] args) {
        String line = "";
        SingleNode head = stringToListNode(line);
        int n = Integer.parseInt(line);
        SingleNode ret = removeNthFromEnd(head, n);
        String out = listNodeToString(ret);
        System.out.print(out);
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