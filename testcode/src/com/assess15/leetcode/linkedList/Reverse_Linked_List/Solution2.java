package com.assess15.leetcode.linkedList.Reverse_Linked_List;

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
