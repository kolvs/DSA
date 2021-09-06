package com.laychv.leetcode.linkedList._237_Delete_Node_in_a_Linked_List;

import com.laychv.leetcode.linkedList.base.node.ListNode;

class Solution {
    public void deleteNode(ListNode node) {
      node.val = node.next.val;
      node.next = node.next.next;
    }
}