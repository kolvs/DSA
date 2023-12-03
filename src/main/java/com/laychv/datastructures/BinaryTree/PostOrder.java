package com.laychv.datastructures.BinaryTree;

import com.laychv.common.TreeNode;

import java.util.*;

import static com.laychv.common.TreeNode.integerArrayListToString;
import static com.laychv.common.TreeNode.stringToTreeNode;

/**
 * 后序遍历
 */
class PostOrder {

    public static void main(String[] args) {
        String x = "[1,null,2,3]";
        System.out.println(integerArrayListToString(postorderTraversal(stringToTreeNode(x))));
        System.out.println(integerArrayListToString(postorderTraversal2(stringToTreeNode(x))));
        System.out.println(integerArrayListToString(postorderTraversal3(stringToTreeNode(x))));
    }

    // dfs == recursion
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private static void postorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    // bfs == iterator + stack
    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        TreeNode cur = root;

        while (!deque.isEmpty()) {
            TreeNode peek = deque.peek();
            if (peek.left != null && peek.left != cur && peek.right != cur) {
                deque.push(peek.left);
            } else if (peek.right != null && peek.right != cur) {
                deque.push(peek.right);
            } else {
                res.add(deque.pop().val);
//                System.out.print(stack.pop().val + " ");
                cur = peek;
            }
        }

        return res;
    }

    public static List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        TreeNode cur1 = root;//遍历树的指针变量
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
                    postMorrisPrint(cur1.left,res);
                }
            }
            cur1 = cur1.right;
        }
        postMorrisPrint(root,res);

        return res;
    }

    //打印函数
    public static void postMorrisPrint(TreeNode head,List<Integer> res) {
        TreeNode reverseList = postMorrisReverseList(head);
        TreeNode cur = reverseList;
        while (cur != null) {
//            System.out.print(cur.val + " ");
            res.add(cur.val);
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