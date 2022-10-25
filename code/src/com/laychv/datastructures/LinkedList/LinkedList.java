package com.laychv.datastructures.LinkedList;

import com.laychv.common.ListNode;

import static com.laychv.common.ListNode.listNodeToString;
import static com.laychv.common.ListNode.stringToListNode;

/**
 * 链表
 * 迭代框架
 * 迭代访问/递归访问
 */
public class LinkedList {

    public static void main(String[] args) {
        String str = "[1,2,3,4,5]";
        ListNode head = stringToListNode(str);

        ListNode loop = loop(head);
        ListNode loop2 = loop2(head);
        ListNode loop3 = reverse(head);
        ListNode loop4 = reverseN(head, 3);

        System.out.println(listNodeToString(reverseRange(head, 2, 4)));
    }

    private static ListNode loop(ListNode head) {
        // 递归 取值 head.value
        if (head.next == null) return head;
        ListNode rs = loop(head.next);
        return rs;
    }

    private static ListNode loop2(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {
            // 迭代 取值 p.value
            System.out.println(p.val);
        }
        return head;
    }

    /**
     * 递归版 反转链表
     *
     * @param head
     * @return
     */
    private static ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 部分反转链表
     * head = 1,2,3,4,5
     * m = 2
     * n = 4
     * head = 1,4,3,2,5
     *
     * @param head
     * @param m    start
     * @param n    end
     * @return
     */
    private static ListNode reverseRange(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseRange(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 反转链表前N节点
     *
     * @param head
     * @param n
     * @return
     */
    private static ListNode reverseN(ListNode head, int n) {
        ListNode cur = null;
        if (n == 1) {
            cur = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = cur;
        return last;
    }

}
