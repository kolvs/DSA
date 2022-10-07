package com.laychv.leetcode;

import com.laychv.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.laychv.common.PrintTreeNode.integerArrayListToString;
import static com.laychv.common.PrintTreeNode.stringToTreeNode;

/**
 * 144. 二叉树的前序遍历
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * <p>
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/?plan=data-structures&plan_progress=svs5wbc
 */
public class _144_BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        String x = "[1,null,2,3]";// 123
        System.out.println(integerArrayListToString(preorderTraversal(stringToTreeNode(x))));
        System.out.println(integerArrayListToString(preorderTraversal2(stringToTreeNode(x))));
        System.out.println(integerArrayListToString(preorderTraversal3(stringToTreeNode(x))));
    }

    // iterator + stack
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            // 注意左右顺序
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }

    // recursion
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preoder(root, res);
        return res;
    }

    static void preoder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preoder(root.left, res);
        preoder(root.right, res);
    }

    // morris
    public static List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        TreeNode p1 = root, p2 = null;

        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    res.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                }
            } else {
                res.add(p1.val);
            }
            p1 = p1.right;
        }
        return res;
    }
}