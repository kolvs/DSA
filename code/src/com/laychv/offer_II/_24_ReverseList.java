package com.laychv.offer_II;

import com.laychv.common.ListNode;

import static com.laychv.common.PrintListNode.listNodeToString;
import static com.laychv.common.PrintListNode.stringToListNode;

/**
 * 剑指 Offer II 024. 反转链表 🟢
 * <p>
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
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
 * https://leetcode.cn/problems/UHnkqh/
 */
public class _24_ReverseList {

    public static void main(String[] args) {
        String x = "[1,2,3,4,5]";
        System.out.print(listNodeToString(reverseList(stringToListNode(x))));
    }

    public static ListNode reverseList(ListNode head) {
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
}
