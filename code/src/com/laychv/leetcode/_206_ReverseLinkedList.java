package com.laychv.leetcode;

import com.laychv.common.SingleNode;

import static com.laychv.common.PrintSingleNode.listNodeToString;
import static com.laychv.common.PrintSingleNode.stringToListNode;

/**
 * 206. 反转链表
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
    public static SingleNode reverseList(SingleNode head) {
        // 终止条件,当前或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        // 获取最后一个节点
        SingleNode cur = reverseList(head.next);
        //
        head.next.next = head;
        //
        head.next = null;
        return cur;
    }

    // 迭代
    public SingleNode reverseList2(SingleNode head) {
        SingleNode prev = null;
        SingleNode curr = head;

        while (curr != null) {
            SingleNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public SingleNode reverseList3(SingleNode head) {
        SingleNode prev = null;
        SingleNode next = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
