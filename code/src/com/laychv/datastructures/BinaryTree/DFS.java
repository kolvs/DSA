package com.laychv.datastructures.BinaryTree;

import com.laychv.common.TreeNode;

/**
 * 广度优先
 * 递归
 */
public class DFS {

    public void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        dfs(root.right);
    }
}
