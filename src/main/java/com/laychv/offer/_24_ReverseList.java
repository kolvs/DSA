package com.laychv.offer;

import com.laychv.common.ListNode;

import static com.laychv.common.ListNode.listNodeToString;
import static com.laychv.common.ListNode.stringToListNode;

/**
 * 剑指 Offer 24. 反转链表 🟢
 * <p>
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 限制：0 <= 节点个数 <= 5000
 * <p>
 * https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/
 */
public class _24_ReverseList {

    public static void main(String[] args) {
        String x = "[1,2,3,4,5]";
        System.out.println(listNodeToString(reverseList(stringToListNode(x))));
        System.out.println(listNodeToString(reverseList2(stringToListNode(x))));
    }

    // iterator
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

    // recursion
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

}
