package com.laychv.leetcode.linkedList.base.deleteByKey;

public class LinkedList {

    Node head;

    /**
     * insert
     *
     * @param list
     * @param data
     */
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
     * traversal
     *
     * @param list
     */
    public static void printList(LinkedList list) {
        Node node = list.head;
        while (node != null) {
            System.out.println(node.data + "...");
            node = node.next;
        }
    }

    /**
     * delete by key
     *
     * @param list
     * @param key
     */
    public static void deleteByKey(LinkedList list, int key) {
        Node curr = list.head;
        Node prev = null;
        if (curr != null && curr.data == key) {
            System.out.println(key + "delete");
            list.head = curr.next;
        }
        while (curr != null && curr.data != key) {
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
     * @param args
     */
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
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

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
