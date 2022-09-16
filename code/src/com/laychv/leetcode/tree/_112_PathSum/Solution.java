package com.laychv.leetcode.tree._112_PathSum;

import com.laychv.leetcode.tree.TreeNode;

/**
 * 递归
 * 时间复杂度：O(N)
 * 空间复杂度：O(H) H树的高度
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null || root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
