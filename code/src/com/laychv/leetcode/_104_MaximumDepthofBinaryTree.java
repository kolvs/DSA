package com.laychv.leetcode;

import com.laychv.common.TreeNode;

import static com.laychv.common.PrintTreeNode.stringToTreeNode;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明:叶子节点是指没有子节点的节点。
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度3
 * <p>
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree
 */
class _104_MaximumDepthofBinaryTree {

    public static void main(String[] args) {
        String x = "[3,9,20,null,null,15,7]";
        System.out.println(maxDepth(stringToTreeNode(x)));
        System.out.println(maxDepth1(stringToTreeNode(x)));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static int maxDepth1(TreeNode root) {
        return root != null ? Math.max(maxDepth(root.left), maxDepth(root.right)) + 1 : 0;
    }
}