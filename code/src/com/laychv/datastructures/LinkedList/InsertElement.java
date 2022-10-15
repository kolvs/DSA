package com.laychv.datastructures.LinkedList;

import com.laychv.common.ListNode;

/**
 * 单链表插入
 */
public class InsertElement {

    ListNode head;

    /**
     * linked List
     * insert
     **/
    public static void insert(InsertElement list, int data) {
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
     * traversal print linked list
     *
     * @param list
     */
    public static void printList(InsertElement list) {
        ListNode curr = list.head;
        while (curr != null) {
            System.out.println(curr.val + " - insert");
            curr = curr.next;
        }
    }

    /**
     * 测试单链表插入
     *
     * @param args
     */
    public static void main(String[] args) {
        InsertElement linkedList = new InsertElement();

        insert(linkedList, 1);
        insert(linkedList, 2);
        insert(linkedList, 3);
        insert(linkedList, 4);
        insert(linkedList, 5);
        insert(linkedList, 6);

        printList(linkedList);
    }

}
