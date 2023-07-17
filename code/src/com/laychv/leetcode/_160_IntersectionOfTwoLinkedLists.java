package com.laychv.leetcode;

import com.laychv.common.ListNode;

import static com.laychv.common.ListNode.stringToListNode;

/**
 * 160. 相交链表 🟢
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * <p>
 * 输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * <p>
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 *
 * <p>
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
 */
public class _160_IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        ListNode node = getIntersectionNode(stringToListNode("[4,1,8,4,5]"), stringToListNode("[5,6,1,8,4,5]"));
        System.out.println(node);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA, b = headB;
        while (a != b) {
            if (a == null) a = headB;
            else a = a.next;
            if (b == null) b = headA;
            else b = b.next;
        }
        return a;
    }
}
