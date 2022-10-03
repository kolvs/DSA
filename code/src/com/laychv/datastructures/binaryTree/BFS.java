package com.laychv.datastructures.binaryTree;

import com.laychv.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 深度优先
 * 队列
 */
public class BFS {

    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();// new LinkedList<>()
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null) queue.add(node.right);
            if (node.left != null) queue.add(node.left);
        }
    }
}
