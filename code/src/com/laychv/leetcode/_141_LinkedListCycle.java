package com.laychv.leetcode;

import com.laychv.common.ListNode;

import java.util.HashSet;
import java.util.Set;

import static com.laychv.common.ListNode.stringToListNode;

/**
 * 141. 环形链表 🟢
 * <p>
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * https://leetcode.cn/problems/linked-list-cycle
 */
public class _141_LinkedListCycle {

    // error test code ❌
    public static void main(String[] args) {
        String x = "[3,2,0,-4]";
        int y = 1; // pos 不作为参数进行传递
        System.out.println(hasCycle(stringToListNode(x)));
    }

    /**
     * set
     */
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) return true;
            head = head.next;
        }
        return false;
    }

    /**
     * fast/slow pointers
     */
    public static boolean hasCycle2(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode fast = head, slow = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，说明含有环
            if (slow == fast) return true;
        }
        return false;
    }
}
