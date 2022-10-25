package com.laychv.leetcode;

import com.laychv.common.TreeNode;

import static com.laychv.common.TreeNode.stringToTreeNode;

/**
 * 111 二叉树的最小深度 🟢
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * <p>
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * <p>
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree
 */
public class _111_MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        String x = "[2,null,3,null,4,null,5,null,6]";
        System.out.print(minDepth(stringToTreeNode(x)));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
