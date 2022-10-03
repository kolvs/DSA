package com.laychv.datastructures.binaryTree;

import com.laychv.common.TreeNode;

/**
 * 广度有限
 * 递归
 */
public class DFS {

    public void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        dfs(root.right);
    }
}
