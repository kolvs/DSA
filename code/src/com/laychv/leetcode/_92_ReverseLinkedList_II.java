package com.laychv.leetcode;

import com.laychv.common.ListNode;

import static com.laychv.common.PrintListNode.listNodeToString;
import static com.laychv.common.PrintListNode.stringToListNode;

/**
 * 92. 反转链表 II 🟠
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * https://leetcode.cn/problems/reverse-linked-list-ii/
 */
public class _92_ReverseLinkedList_II {

    public static void main(String[] args) {
        String x = "[1,2,3,4,5]";
        int left = 2;
        int right = 4;
        System.out.println(listNodeToString(reverseBetween(stringToListNode(x), left, right)));
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // 虚拟头结点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;

        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode next = null;
        ListNode curr = pre.next;

        for (int i = 0; i < n - m; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
