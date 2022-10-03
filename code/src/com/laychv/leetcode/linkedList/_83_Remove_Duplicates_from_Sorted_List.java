package com.laychv.leetcode.linkedList;

import com.laychv.common.SingleNode;

import java.io.IOException;

import static com.laychv.common.PrintSingleNode.listNodeToString;
import static com.laychv.common.PrintSingleNode.stringToListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 输入: 1->1->2
 * 输出: 1->2
 * <p>
 * [1,1,2]
 * [1,2]
 */
class _83_Remove_Duplicates_from_Sorted_List {

    public static void main(String[] args) {
        String line = "";
        SingleNode head = stringToListNode(line);
        SingleNode ret = new _83_Remove_Duplicates_from_Sorted_List().deleteDuplicates(head);
        String out = listNodeToString(ret);
        System.out.print(out);
    }

    public SingleNode deleteDuplicates(SingleNode head) {
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
}