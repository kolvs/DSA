package com.laychv.leetcode.tree.CountCompleteTreeNodes;

import com.laychv.leetcode.tree.TreeNode;

/**
 * DFS深度优先
 */
class Solution {
    public int countNodes(TreeNode root) {
        return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }
}