package com.laychv.leetcode.linkedList;

import com.laychv.common.SingleNode;

import static com.laychv.common.PrintSingleNode.listNodeToString;
import static com.laychv.common.PrintSingleNode.stringToListNode;

/**
 * [203. 移除链表元素](https://leetcode-cn.com/problems/remove-linked-list-elements/)
 * <p>
 * 删除链表中等于给定值 ***val*** 的所有节点。
 * <p>
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * <p>
 * 通过虚拟头结点方式删除
 */

class _203_Remove_Linked_List_Elements {

    public static void main(String[] args) {
        String line = "";
        SingleNode head = stringToListNode(line);
        int val = Integer.parseInt(line);
        SingleNode ret = new _203_Remove_Linked_List_Elements().removeElements(head, val);
        String out = listNodeToString(ret);
        System.out.print(out);
    }

    public SingleNode removeElements(SingleNode head, int val) {
        // 虚拟头结点,存放的是head
        SingleNode dummyHead = new SingleNode(0);
        dummyHead.next = head;

        SingleNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                // 删除元素,指针指向下下个元素
                prev.next = prev.next.next;
            } else {
                // 遍历下一个元素
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public SingleNode removeElements2(SingleNode head, int val) {
        SingleNode dummyHead = new SingleNode(0);
        dummyHead.next = head;

        SingleNode curr = head;
        SingleNode prev = dummyHead;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummyHead.next;
    }
}