package com.assess15.algorithm.linkedList.Delete_Node_in_a_LinkedL_ist;

class Solution {
    public void deleteNode(ListNode node) {
      node.val = node.next.val;
      node.next = node.next.next;
    }
}