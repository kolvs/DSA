package com.laychv.leetcode.binaryTree;

import com.laychv.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static com.laychv.common.PrintTreeNode.integerArrayListToString;
import static com.laychv.common.PrintTreeNode.stringToTreeNode;

/**
 * 145. 二叉树的后序遍历
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 */
public class _145_Binary_Tree_Postorder_Traversal {

    public static void main(String[] args) {
        String line = "[1,null,2,3]";
        TreeNode root = stringToTreeNode(line);
        List<Integer> ret = new _145_Binary_Tree_Postorder_Traversal().postorderTraversal(root);
        String out = integerArrayListToString(ret);
        System.out.print(out);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
