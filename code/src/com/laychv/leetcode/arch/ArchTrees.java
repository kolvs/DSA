package com.laychv.leetcode.arch;

public class ArchTrees {

    private static void loop(TreeNode root) {
        for (TreeNode child : root.children) {
            loop(child);
        }
    }

    static class TreeNode {
        int value;
        TreeNode[] children;
    }
}
