package com.laychv.leetcode.linkedList.Palindrome_Linked_List;

import java.util.Stack;

/**
 * 栈
 * 通过栈一半,对比另一半
 */

class Solution2 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode curr = head;
        ListNode right = head.next;
        while (curr.next != null && curr.next.next != null) {
            curr = curr.next.next;
            right = right.next;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}