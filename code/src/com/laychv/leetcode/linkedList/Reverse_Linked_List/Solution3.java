package com.laychv.leetcode.linkedList.Reverse_Linked_List;

/**
 * 迭代
 */
public class Solution3 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
