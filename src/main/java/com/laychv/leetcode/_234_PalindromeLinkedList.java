package com.laychv.leetcode;

import com.laychv.common.ListNode;

import java.util.Stack;

import static com.laychv.common.ListNode.stringToListNode;

/**
 * 234.回文链表 🟢
 * <p>
 * 输入：head = [1,2,2,1]
 * 输出：true
 * <p>
 * 输入：head = [1,2]
 * 输出：false
 * <p>
 * https://leetcode.cn/problems/palindrome-linked-list/
 */
class _234_PalindromeLinkedList {

    public static void main(String[] args) {
        String x = "[1,2,2,1]";
        System.out.print(isPalindrome(stringToListNode(x)));
        System.out.print(isPalindrome2(stringToListNode(x)));
    }

    /**
     * 利用额外的空间 Stack ,利用栈的先进后出,判断先进后出顺序是否一致,通过栈一半,对比另一半
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
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

    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode curr = head;
        ListNode right = head.next;
        while (curr.next != null && curr.next.next != null) {
            curr = curr.next.next;
            right = right.next;
        }
        Stack<ListNode> stack = new Stack<>();
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