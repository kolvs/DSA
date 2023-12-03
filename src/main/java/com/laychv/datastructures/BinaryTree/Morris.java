package com.laychv.datastructures.BinaryTree;

import com.laychv.common.TreeNode;

public class Morris {

    /**
     * 前序
     */
    public static void preorder(TreeNode head) {
        if (head == null) return;

        //当前开始遍历的节点
        TreeNode cur1 = head;
        //记录当前结点的左子树
        TreeNode cur2 = null;

        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                //找到当前左子树的最右侧节点，且这个节点应该在指向根结点之前，否则整个节点又回到了根结点。
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                //这个时候如果最右侧这个节点的右指针没有指向根结点，创建连接然后往下一个左子树的根结点进行连接操作。
                if (cur2.right == null) {
                    cur2.right = cur1;
                    System.out.print(cur1.val + " ");
                    cur1 = cur1.left;
                    continue;
                }
                //当左子树的最右侧节点有指向根结点，此时说明我们已经回到了根结点并重复了之前的操作，同时在回到根结点的时候我们应该已经处理完 左子树的最右侧节点 了，把路断开。
                else {
                    cur2.right = null;
                }
            } else {
                System.out.print(cur1.val + " ");
            }
            //一直往右边走，参考图
            cur1 = cur1.right;
        }
    }

    /**
     * 中序
     */
    public static void inorder(TreeNode head) {
        if (head == null) return;

        TreeNode cur1 = head;
        TreeNode cur2 = null;

        while (cur1 != null) {
            cur2 = cur1.left;
            //构建连接线
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            System.out.print(cur1.val + " ");
            cur1 = cur1.right;
        }
    }

    /**
     * 后序
     */
    public static void postOrderMorris(TreeNode head) {
        if (head == null) return;

        TreeNode cur1 = head;//遍历树的指针变量
        TreeNode cur2 = null;//当前子树的最右节点

        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                    postMorrisPrint(cur1.left);
                }
            }
            cur1 = cur1.right;
        }
        postMorrisPrint(head);
    }

    //打印函数
    public static void postMorrisPrint(TreeNode head) {
        TreeNode reverseList = postMorrisReverseList(head);
        TreeNode cur = reverseList;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        postMorrisReverseList(reverseList);
    }

    //翻转单链表
    public static TreeNode postMorrisReverseList(TreeNode head) {
        TreeNode cur = head;
        TreeNode pre = null;
        while (cur != null) {
            TreeNode next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
