package com.laychv.leetcode.linkedList;

import com.laychv.common.SingleNode;

import static com.laychv.common.PrintSingleNode.listNodeToString;
import static com.laychv.common.PrintSingleNode.stringToListNode;

/**
 * 206. 反转链表
 * 反转一个单链表。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * [1,2,3,4]
 * [4,3,2,1]
 * <p>
 * 递归
 * <p>
 * 迭代
 */
class _206_Reverse_Linked_List {
    public static void main(String[] args) {
        String line = "";
        SingleNode head = stringToListNode(line);
        SingleNode ret = new _206_Reverse_Linked_List().reverseList(head);
        String out = listNodeToString(ret);
        System.out.print(out);
    }

    public SingleNode reverseList(SingleNode head) {
        // 终止条件,当前或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        // 获取最后一个节点
        SingleNode cur = reverseList(head.next);
        //
        head.next.next = head;
        //
        head.next = null;
        return cur;
    }

    public SingleNode reverseList2(SingleNode head) {
        SingleNode prev = null;
        SingleNode curr = head;

        while (curr != null) {
            SingleNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public SingleNode reverseList3(SingleNode head) {
        SingleNode prev = null;
        SingleNode next = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
