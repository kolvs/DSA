package com.laychv.leetcode.tree._226_InvertBinaryTree;

import com.laychv.leetcode.tree.TreeNode;

/**
 * 递归
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
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