package com.laychv.datastructures.binaryTree;

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
        String line = "[1,null,2,3]";
        TreeNode root = stringToTreeNode(line);
        List<Integer> ret = new PostOrder().postorderTraversal(root);
        String out = integerArrayListToString(ret);
        System.out.print(out);
    }

    // 迭代
    public List<Integer> postorderTraversal(TreeNode root) {
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