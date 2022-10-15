package com.laychv.leetcode;

import com.laychv.common.ListNode;

import static com.laychv.common.PrintListNode.listNodeToString;
import static com.laychv.common.PrintListNode.stringToListNode;

/**
 * 237. 删除链表中的节点 🟡
 * <p>
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：指定链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9
 * <p>
 * 输入：head = [4,5,1,9], node = 1
 * 输出：[4,5,9]
 * 解释：指定链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9
 * <p>
 * https://leetcode.cn/problems/delete-node-in-a-linked-list/
 */
class _237_DeleteNodeInALinkedList {

    public static void main(String[] args) {
        String x = "[4,5,1,9]";
        int node = 5;
        ListNode head = stringToListNode(x);
        deleteNode(head, node);
        System.out.print(listNodeToString(head));
    }

    public static void deleteNode(ListNode node, int n) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}