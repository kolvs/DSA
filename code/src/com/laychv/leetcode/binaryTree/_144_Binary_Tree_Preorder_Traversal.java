package com.laychv.leetcode.binaryTree;

import com.laychv.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.laychv.common.PrintTreeNode.integerArrayListToString;
import static com.laychv.common.PrintTreeNode.stringToTreeNode;

/**
 * 144. 二叉树的前序遍历
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/?plan=data-structures&plan_progress=svs5wbc
 */
public class _144_Binary_Tree_Preorder_Traversal {

    public static void main(String[] args) {
        String line = "[1,null,2,3]";// 123
        String line2 = "[3,1,2]";// 312
        System.out.println(integerArrayListToString(preorderTraversal(stringToTreeNode(line))));
        System.out.println(integerArrayListToString(preorderTraversal(stringToTreeNode(line2))));
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
}