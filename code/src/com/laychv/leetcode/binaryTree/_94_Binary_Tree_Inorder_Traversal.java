package com.laychv.leetcode.binaryTree;

import com.laychv.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.laychv.common.PrintTreeNode.integerArrayListToString;
import static com.laychv.common.PrintTreeNode.stringToTreeNode;

/**
 * 94. 二叉树的中序遍历
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 */
public class _94_Binary_Tree_Inorder_Traversal {

    public static void main(String[] args) {
        String line = "[1,null,2,3]";
        TreeNode root = stringToTreeNode(line);
        List<Integer> ret = new _94_Binary_Tree_Inorder_Traversal().inorderTraversal(root);
        String out = integerArrayListToString(ret);
        System.out.print(out);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
