package com.laychv.leetcode.linkedList._203_Remove_Linked_List_Elements;

import com.laychv.leetcode.linkedList.base.node.ListNode;

public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode curr = head;
        ListNode prev = dummyHead;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummyHead.next;
    }
}
