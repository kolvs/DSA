package com.laychv.leetcode.arch;

/**
 * 二叉树
 */
public class ArchTree {

    private static void loop(TreeNode head) {
        loop(head.left);
        loop(head.right);
    }

    public static void main(String[] args) {

    }

    static class TreeNode {
        int value;
        TreeNode left, right;
    }
}
