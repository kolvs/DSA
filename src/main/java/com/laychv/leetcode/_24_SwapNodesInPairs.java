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
        System.out.println(listNodeToString(swapPairs2(stringToListNode("[1,2,3,4]"))));
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

    // 虚拟头结点
    public static ListNode swapPairs2(ListNode head) {
        // 创建一个虚拟头结点
        ListNode dum = new ListNode(-1);
        // 将虚拟头结点指向原链表的头结点
        dum.next = head;
        // 创建prev指针，初始指向虚拟头结点，prev的作用：指向待交换一对节点的前一个节点
        ListNode prev = dum;

        // 第4行：开始循环，条件是存在两个连续的节点可以交换
        // prev.next != null：确保第一个节点存在
        // prev.next.next != null：确保第二个节点存在
        while (prev.next != null && prev.next.next != null) {
            // 记录要交换的两个节点
            // first：要交换的第一个节点（即prev.next）
            ListNode first = prev.next;
            // second：要交换的第二个节点（即prev.next.next）
            ListNode second = prev.next.next;

            // 执行交换的第一步
            // 将prev的next指向second（第二个节点）
            // 作用：将前一节点直接连接到第二个节点，跳过第一个节点
            prev.next = second;

            // 执行交换的第二步
            // 将first的next指向second的下一个节点
            // 作用：保存第二个节点之后的链表部分
            // 举例：交换前：first->second->third，交换后：first->third
            first.next = second.next;

            // 执行交换的第三步
            // 将second的next指向first
            // 作用：完成节点间的链接反转
            // 举例：交换前：second->third，交换后：second->first->third
            second.next = first;

            // 更新prev指针
            // 将prev移动到交换后的第二个节点（即原来的first节点）
            // 原因：交换后，first变成了这一对的第二个节点
            // 下一对节点的前驱节点应该是当前这对节点的第二个节点
            prev = first;
        }

        return dum.next;
    }
}

