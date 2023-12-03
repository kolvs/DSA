package com.laychv.leetcode;

import com.laychv.common.ListNode;

import static com.laychv.common.ListNode.listNodeToString;
import static com.laychv.common.ListNode.stringToListNode;

/**
 * 82. 删除排序链表中的重复元素 II 🟠
 * <p>
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * <p>
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 */
public class _82_RemoveDuplicatesFromSortedList_II {

    public static void main(String[] args) {
        System.out.println("[1,2,5]->:" + listNodeToString(deleteDuplicates(stringToListNode("[1,2,3,3,4,4,5]"))));
        System.out.println("[2,3]->:" + listNodeToString(deleteDuplicates(stringToListNode("[1,1,1,2,3]"))));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        // 虚拟头结点
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
