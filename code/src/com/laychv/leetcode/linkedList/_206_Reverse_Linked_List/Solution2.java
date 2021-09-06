package com.laychv.leetcode.linkedList._206_Reverse_Linked_List;

import com.laychv.leetcode.linkedList.base.node.ListNode;

/**
 * 迭代
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
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
