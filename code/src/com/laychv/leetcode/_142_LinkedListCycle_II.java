package com.laychv.leetcode;

import com.laychv.common.ListNode;

import java.util.HashSet;
import java.util.Set;

import static com.laychv.common.PrintListNode.stringToListNode;

/**
 * 142. 环形链表 II 🟡
 * <p>
 * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。不允许修改 链表。
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * <p>
 * https://leetcode.cn/problems/linked-list-cycle-ii
 */
public class _142_LinkedListCycle_II {

    // error test code ❌
    public static void main(String[] args) {
        String x = "[3,2,0,-4]";
        int y = 1; // pos 不作为参数进行传递
        System.out.println(detectCycle(stringToListNode(x)));
        System.out.println(detectCycle2(stringToListNode(x)));
    }

    /**
     * set
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode temp = head;
        Set<ListNode> set = new HashSet<>();

        while (temp != null) {
            if (set.contains(head)) {
                return temp;
            } else {
                set.add(temp);
            }
            temp = temp.next;
        }

        return null;
    }

    /**
     * slow/fast pointers
     */
    public static ListNode detectCycle2(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode temp = head;
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
            }
        }

        return null;
    }

}
