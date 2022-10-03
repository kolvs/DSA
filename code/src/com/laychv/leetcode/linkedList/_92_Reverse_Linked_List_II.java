package com.laychv.leetcode.linkedList;

import com.laychv.common.SingleNode;

import java.io.IOException;

import static com.laychv.common.PrintSingleNode.listNodeToString;
import static com.laychv.common.PrintSingleNode.stringToListNode;

public class _92_Reverse_Linked_List_II {
    public static void main(String[] args) {
        String line = "";
        SingleNode head = stringToListNode(line);
        int left = Integer.parseInt(line);
        int right = Integer.parseInt(line);
        SingleNode ret = new _92_Reverse_Linked_List_II().reverseBetween(head, left, right);
        String out = listNodeToString(ret);
        System.out.print(out);
    }

    public SingleNode reverseBetween(SingleNode head, int m, int n) {
        // 虚拟头结点
        SingleNode dummyNode = new SingleNode(-1);
        dummyNode.next = head;
        SingleNode pre = dummyNode;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        SingleNode curr = pre.next;
        SingleNode next = null;
        for (int i = 0; i < n - m; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
