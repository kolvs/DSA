package com.laychv.leetcode.linkedList;

import com.laychv.common.SingleNode;

import java.io.IOException;
import java.util.Stack;

import static com.laychv.common.PrintSingleNode.booleanToString;
import static com.laychv.common.PrintSingleNode.stringToListNode;

/**
 * 234.回文链表
 * <p>
 * 利用额外的空间 Stack ,利用栈的先进后出,判断先进后出顺序是否一致
 * <p>
 * 栈
 * 通过栈一半,对比另一半
 */

class _234_Palindrome_Linked_List {

    public static void main(String[] args) {
        String line = "";
        SingleNode head = stringToListNode(line);
        boolean ret = new _234_Palindrome_Linked_List().isPalindrome(head);
        String out = booleanToString(ret);
        System.out.print(out);
    }

    public boolean isPalindrome(SingleNode head) {
        Stack<SingleNode> stack = new Stack<SingleNode>();
        SingleNode curr = head;
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

    public boolean isPalindrome2(SingleNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        SingleNode curr = head;
        SingleNode right = head.next;
        while (curr.next != null && curr.next.next != null) {
            curr = curr.next.next;
            right = right.next;
        }
        Stack<SingleNode> stack = new Stack<SingleNode>();
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