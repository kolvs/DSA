package com.laychv.leetcode.linkedList;

import com.laychv.common.SingleNode;

import java.io.IOException;

import static com.laychv.common.PrintSingleNode.listNodeToString;
import static com.laychv.common.PrintSingleNode.stringToListNode;

/**
 * [237. 删除链表中的节点](https://leetcode-cn.com/problems/delete-node-in-a-linked-list/)
 * <p>
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * <p>
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 * 示例2:
 * 输入: head = [4,5,1,9], node = 1
 * <p>
 * 说明:
 * <p>
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 */
class _237_Delete_Node_in_a_Linked_List {
    
    public static void main(String[] args) {
        String line = "";
        SingleNode node = stringToListNode(line);
        int n = Integer.parseInt(line);
        new _237_Delete_Node_in_a_Linked_List().deleteNode(node);
        String out = listNodeToString(node);

        System.out.print(out);
    }

    public void deleteNode(SingleNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}