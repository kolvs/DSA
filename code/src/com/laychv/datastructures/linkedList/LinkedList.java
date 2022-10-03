package com.laychv.datastructures.linkedList;

import com.laychv.common.SingleNode;
import com.laychv.common.PrintLinkedList;

/**
 * 链表
 * 迭代框架
 * 迭代访问/递归访问
 */
public class LinkedList {

    private static SingleNode loop(SingleNode head) {
        // 递归 取值 head.value
        if (head.next == null) return head;
        SingleNode rs = loop(head.next);
        return rs;
    }

    private static SingleNode loop2(SingleNode head) {
        for (SingleNode p = head; p != null; p = p.next) {
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
    private static SingleNode reverse(SingleNode head) {
        if (head.next == null) return head;
        SingleNode last = reverse(head.next);
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
    private static SingleNode reverseRange(SingleNode head, int m, int n) {
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
    private static SingleNode reverseN(SingleNode head, int n) {
        SingleNode cur = null;
        if (n == 1) {
            cur = head.next;
            return head;
        }
        SingleNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = cur;
        return last;
    }

    public static void main(String[] args) {
        String str = "[1,2,3,4,5]";
        SingleNode head = PrintLinkedList.getInstance().stringToListNode(str);

//        TreeNode loop = loop(head);
//        TreeNode loop = loop2(head);
//        TreeNode loop = reverse(head);
//        TreeNode loop = reverseN(head, 3);
        SingleNode loop = reverseRange(head, 2, 4);

        String string = PrintLinkedList.getInstance().listNodeToString(loop);
        System.out.println(string);
    }

}
