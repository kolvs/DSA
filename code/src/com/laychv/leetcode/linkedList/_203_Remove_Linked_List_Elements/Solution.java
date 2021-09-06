package com.laychv.leetcode.linkedList._203_Remove_Linked_List_Elements;

import com.laychv.leetcode.linkedList.base.node.ListNode;

/**
 * 通过虚拟头结点方式删除
 */

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 虚拟头结点,存放的是head
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                // 删除元素,指针指向下下个元素
                prev.next = prev.next.next;
            } else {
                // 遍历下一个元素
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
}