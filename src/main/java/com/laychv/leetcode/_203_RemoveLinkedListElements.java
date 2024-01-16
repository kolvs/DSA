package com.laychv.leetcode;

import com.laychv.common.ListNode;

import static com.laychv.common.ListNode.listNodeToString;
import static com.laychv.common.ListNode.stringToListNode;

/**
 * 203. 移除链表元素 🟢
 * <p>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * <p>
 * https://leetcode.cn/problems/remove-linked-list-elements/
 */
class _203_RemoveLinkedListElements {

    public static void main(String[] args) {
        String x = "[1,2,6,3,4,5,6]";
        int val = 6;
        System.out.print(listNodeToString(removeElements(stringToListNode(x), val)));
        System.out.print(listNodeToString(removeElements2(stringToListNode(x), val)));
        System.out.print(listNodeToString(removeElements3(stringToListNode(x), val)));
    }

    //  通过虚拟头结点方式删除
    public static ListNode removeElements(ListNode head, int val) {
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

    public static ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode curr = head;
        ListNode prev = dummyHead;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummyHead.next;
    }

    /**
     * 递归
     */
    public static ListNode removeElements3(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements3(head.next, val);
        return head.val == val ? head.next : head;
    }
}