package com.laychv.leetcode.linkedList._206_Reverse_Linked_List;

import com.laychv.leetcode.linkedList.base.node.ListNode;

/**
 * 递归
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // 终止条件,当前或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        // 获取最后一个节点
        ListNode cur = reverseList(head.next);
        //
        head.next.next = head;
        //
        head.next = null;
        return cur;
    }
}
