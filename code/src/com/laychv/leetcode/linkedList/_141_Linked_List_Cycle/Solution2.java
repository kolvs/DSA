package com.laychv.leetcode.linkedList._141_Linked_List_Cycle;

import com.laychv.leetcode.linkedList.base.node.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 哈希表
 * 存入哈希表中,如果存在过表示有环
 */
public class Solution2 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return true;
            } else {
                nodeSet.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
