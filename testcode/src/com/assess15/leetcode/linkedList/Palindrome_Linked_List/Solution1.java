package com.assess15.leetcode.linkedList.Palindrome_Linked_List;

import java.util.Stack;

/**
 * 解法:利用额外的空间 Stack ,利用栈的先进后出,判断先进后出顺序是否一致
 */

class Solution1 {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}