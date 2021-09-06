package com.laychv.leetcode.linkedList._92_Reverse_Linked_List_II;

import com.laychv.leetcode.linkedList.base.node.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 虚拟头结点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode curr = pre.next;
        ListNode next = null;
        for (int i = 0; i < n - m; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
