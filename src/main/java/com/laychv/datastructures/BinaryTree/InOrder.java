package com.laychv.datastructures.BinaryTree;

import com.laychv.common.TreeNode;

import java.util.*;

import static com.laychv.common.TreeNode.integerArrayListToString;
import static com.laychv.common.TreeNode.stringToTreeNode;

/**
 * 中序遍历
 * <p>
 * 递归 dfs
 * 迭代 bfs
 * Morris
 * <p>
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
 */
public class InOrder {

    public static void main(String[] args) {
        String x = "[1,null,2,3]";
        System.out.println(integerArrayListToString(inorderTraversal(stringToTreeNode(x))));
        System.out.println(integerArrayListToString(inorderTraversal2(stringToTreeNode(x))));
        System.out.println(integerArrayListToString(inorderTraversal3(stringToTreeNode(x))));
    }

    // dfs == recursion
    static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    // bfs == iterator + stack
    static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                cur = node.right;
            }
        }
        return res;
    }

    // morris
    static List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        TreeNode cur1 = root;
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
            res.add(cur1.val);
            cur1 = cur1.right;
        }
        return res;
    }

}
