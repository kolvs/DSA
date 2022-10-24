package com.laychv.datastructures.BinaryTree;

import com.laychv.common.TreeNode;

import java.util.*;

/**
 * 深度优先
 * 队列
 * LinkedList
 * Queue---ArrayDeque
 * Deque---ArrayDeque
 * Stack
 */
public class BFS {

    public void bfs(TreeNode root) {
        // just suit for java language
        LinkedList<TreeNode> linkedList = new LinkedList<>();

        linkedList.add(root);

        while (!linkedList.isEmpty()) {
            TreeNode node = linkedList.poll();
            if (node.left != null) linkedList.add(node.left);
            if (node.right != null) linkedList.add(node.right);
        }
    }

    public void bfs2(TreeNode root) {
        // just suit for java language
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    public void bfs3(TreeNode root) {
        // just suit for java language
        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.add(root);

        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if (node.left != null) deque.add(node.left);
            if (node.right != null) deque.add(node.right);
        }
    }

    public void bfs4(TreeNode root) {
        // just suit for java language
        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
        }
    }

}
