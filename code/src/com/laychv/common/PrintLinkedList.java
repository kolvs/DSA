package com.laychv.common;

public class PrintLinkedList {
    private static final PrintLinkedList utils = new PrintLinkedList();

    private PrintLinkedList() {
    }

    public static PrintLinkedList getInstance() {
        return utils;
    }

    private static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public SingleNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        SingleNode dummyRoot = new SingleNode(0);
        SingleNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new SingleNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public String listNodeToString(SingleNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += node.val + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
}
