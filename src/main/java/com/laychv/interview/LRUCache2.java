package com.laychv.interview;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    private int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node();
    private Node tail = new Node();

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            if (map.size() == capacity) {
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }
            Node node = new Node();
            node.key = key;
            node.value = value;
            map.put(key, node);
            addToHead(node);
        }
    }

    private void addToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void moveToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
