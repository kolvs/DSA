package com.assess15.leetcode.tree.MaximumDepthofBinaryTree;

import com.assess15.leetcode.tree.TreeNode;

/**
 * 时间复杂度：O(n)，其中 n 为二叉树节点的个数。每个节点在递归中只被遍历一次。
 * 空间复杂度：O(height)，其中 height 表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度，因此空间复杂度等价于二叉树的高度。
 */
public class Solution2 {
    public int maxDepth(TreeNode root) {
        return root != null ? Math.max(maxDepth(root.left), maxDepth(root.right)) + 1 : 0;
    }
}
