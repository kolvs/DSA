package com.laychv.leetcode;

import com.laychv.common.SingleNode;

import static com.laychv.common.PrintSingleNode.listNodeToString;
import static com.laychv.common.PrintSingleNode.stringToListNode;

/**
 * 203. 移除链表元素 🟢
 * <p>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * <p>
 * https://leetcode.cn/problems/remove-linked-list-elements/
 */
class _203_RemoveLinkedListElements {

    public static void main(String[] args) {
        String x = "[1,2,6,3,4,5,6]";
        int val = 6;
        System.out.print(listNodeToString(removeElements(stringToListNode(x), val)));
        System.out.print(listNodeToString(removeElements2(stringToListNode(x), val)));
    }

    //  通过虚拟头结点方式删除
    public static SingleNode removeElements(SingleNode head, int val) {
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

    public static SingleNode removeElements2(SingleNode head, int val) {
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