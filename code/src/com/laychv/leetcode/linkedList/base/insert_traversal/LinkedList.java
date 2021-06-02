package com.laychv.leetcode.linkedList.base.insert_traversal;


/**
 * 单链表插入
 */
public class LinkedList {

    Node head;

    /**
     * linked List
     * insert
     **/
    public static void insert(LinkedList list, int data) {
        Node new_node = new Node(data);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
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
    public static void printList(LinkedList list) {
        Node curr = list.head;
        while (curr != null) {
            System.out.println(curr.data + " - insert");
            curr = curr.next;
        }
    }

    /**
     * 测试单链表插入
     *
     * @param args
     */
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        insert(linkedList, 1);
        insert(linkedList, 2);
        insert(linkedList, 3);
        insert(linkedList, 4);
        insert(linkedList, 5);
        insert(linkedList, 6);

        printList(linkedList);
    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

}
