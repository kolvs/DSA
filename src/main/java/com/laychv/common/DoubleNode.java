package com.laychv.common;

public class DoubleNode {
    public int key;
    public int value;
    public DoubleNode prev;
    public DoubleNode next;

    public DoubleNode() {
    }

    public DoubleNode(int value) {
        this.value = value;
    }

    public DoubleNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
