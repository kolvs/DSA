package com.laychv.leetcode;

import com.laychv.common.ListNode;

import static com.laychv.common.ListNode.listNodeToString;
import static com.laychv.common.ListNode.stringToListNode;

/**
 * 24. 两两交换链表中的节点 🟠
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * <p>
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/
 */
public class _24_SwapNodesInPairs {

    public static void main(String[] args) {
        System.out.println(listNodeToString(swapPairs(stringToListNode("[]"))));
        System.out.println(listNodeToString(swapPairs(stringToListNode("[1]"))));
        System.out.println(listNodeToString(swapPairs(stringToListNode("[1,2,3,4]"))));
    }

    /***递归***/
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode n1 = head;
        ListNode n2 = head.next;
        ListNode n3 = head.next.next;// n2.next
        n2.next = n1;
        n1.next = swapPairs(n3);
        return n2;
    }
}

