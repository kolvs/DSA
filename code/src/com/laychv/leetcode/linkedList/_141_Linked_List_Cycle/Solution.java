package com.laychv.leetcode.linkedList._141_Linked_List_Cycle;

import com.laychv.leetcode.linkedList.base.node.ListNode;

/**
 * 快慢指针
 * 慢指针走一步
 * 快指针走两步
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
