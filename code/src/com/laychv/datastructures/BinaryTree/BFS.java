package com.laychv.datastructures.BinaryTree;

import com.laychv.common.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 深度优先
 * 队列:LinkedList/ArrayDeque
 */
public class BFS {

    public void bfs(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null) queue.add(node.right);
            if (node.left != null) queue.add(node.left);
        }
    }
}
