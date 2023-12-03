package com.laychv.datastructures.BinaryTree;

import com.laychv.common.TreeNode;

import java.util.List;

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

    public void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;

        res.add(root.val);// preorder

        dfs(root.left, res);

        res.add(root.val);// inorder

        dfs(root.right, res);

        res.add(root.val);// postorder
    }
}
