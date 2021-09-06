package com.laychv.leetcode.linkedList._83_Remove_Duplicates_from_Sorted_List;

import com.laychv.leetcode.linkedList.base.node.ListNode;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            // 相等,删除节点
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                // 不相等,移动到下一个节点
                curr = curr.next;
            }
        }
        return head;
    }
}