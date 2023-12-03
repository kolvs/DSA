package com.laychv.leetcode;

import com.laychv.common.TreeNode;

import static com.laychv.common.TreeNode.stringToTreeNode;
import static com.laychv.common.TreeNode.treeNodeToString;

/**
 * 226. 翻转二叉树 🟢
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * <p>
 * https://leetcode.cn/problems/invert-binary-tree
 */
class _226_InvertBinaryTree {

    public static void main(String[] args) {
        String x = "[4,2,7,1,3,6,9]";
        System.out.print(treeNodeToString(invertTree(stringToTreeNode(x))));
    }

    // recursion
    public static TreeNode invertTree(TreeNode root) {
        // 终止条件
        if (root == null) {
            return null;
        }
        // 本级递归
        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        root.left = left;
        root.right = right;
        // 递归返回值
        return root;
    }
}