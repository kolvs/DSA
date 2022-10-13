package com.laychv.leetcode;

import com.laychv.common.SingleNode;

import static com.laychv.common.PrintSingleNode.listNodeToString;
import static com.laychv.common.PrintSingleNode.stringToListNode;

/**
 * 92. 反转链表 II 🟡
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * https://leetcode.cn/problems/reverse-linked-list-ii/
 */
public class _92_ReverseLinkedList_II {

    public static void main(String[] args) {
        String x = "[1,2,3,4,5]";
        int left = 2;
        int right = 4;
        System.out.println(listNodeToString(reverseBetween(stringToListNode(x), left, right)));
    }

    public static SingleNode reverseBetween(SingleNode head, int m, int n) {
        // 虚拟头结点
        SingleNode dummyNode = new SingleNode(-1);
        dummyNode.next = head;
        SingleNode pre = dummyNode;

        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        SingleNode next = null;
        SingleNode curr = pre.next;

        for (int i = 0; i < n - m; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
