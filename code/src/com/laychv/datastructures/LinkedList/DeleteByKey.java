package com.laychv.datastructures.LinkedList;

import com.laychv.common.ListNode;

public class DeleteByKey {

    ListNode head;

    /**
     * insert
     *
     * @param list
     * @param data
     */
    public static void insert(DeleteByKey list, int data) {
        ListNode new_node = new ListNode(data);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        } else {
            ListNode last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }

    }

    /**
     * traversal
     *
     * @param list
     */
    public static void printList(DeleteByKey list) {
        ListNode node = list.head;
        while (node != null) {
            System.out.println(node.val + "...");
            node = node.next;
        }
    }

    /**
     * delete by key
     *
     * @param list
     * @param key
     */
    public static void deleteByKey(DeleteByKey list, int key) {
        ListNode curr = list.head;
        ListNode prev = null;
        if (curr != null && curr.val == key) {
            System.out.println(key + "delete");
            list.head = curr.next;
        }
        while (curr != null && curr.val != key) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            prev.next = curr.next;
        }
        if (curr == null) {
            System.out.println("not found!");
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        DeleteByKey list = new DeleteByKey();
        // insert
        insert(list, 1);
        insert(list, 2);
        insert(list, 3);
        insert(list, 4);
        // print
        printList(list);
        // delete by key
        deleteByKey(list, 4);
        // print
        printList(list);
    }
}
