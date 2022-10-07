package com.laychv.leetcode;

import com.laychv.common.SingleNode;

import static com.laychv.common.PrintSingleNode.listNodeToString;
import static com.laychv.common.PrintSingleNode.stringToListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * <p>
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * <p>
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 */
class _83_RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        String x = "[1,1,2]";
        System.out.print(listNodeToString(deleteDuplicates(stringToListNode(x))));
        System.out.print(listNodeToString(deleteDuplicates2(stringToListNode(x))));
    }

    // iterator
    public static SingleNode deleteDuplicates(SingleNode head) {
        SingleNode curr = head;
        while (curr != null && curr.next != null) {
            // 相等,删除节点
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                // 不相等,移动到下一个节点
                curr = curr.next;
            }
        }
        return head;
    }

    // recursion
    public static SingleNode deleteDuplicates2(SingleNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates2(head.next);
        if (head.val == head.next.val) {
            head = head.next;
        }
        return head;
    }

}