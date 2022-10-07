package com.laychv.datastructures.BinaryTree;

import com.laychv.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.laychv.common.PrintTreeNode.integerArrayListToString;
import static com.laychv.common.PrintTreeNode.stringToTreeNode;

/**
 * 后序遍历
 * 前中后序递归版简单很简洁
 */
class PostOrder {

    public static void main(String[] args) {
        String x = "[1,null,2,3]";
        System.out.print(integerArrayListToString(postorderTraversal(stringToTreeNode(x))));
    }

    // 迭代
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        // stack
        Stack<TreeNode> stack = new Stack<>();
        //
        TreeNode post = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == post) {
                res.add(root.val);
                post = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }

        return res;
    }

}