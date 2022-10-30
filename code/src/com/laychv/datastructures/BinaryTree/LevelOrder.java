package com.laychv.datastructures.BinaryTree;

import com.laychv.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static com.laychv.common.PrintIntegerArray.int2dListToString;
import static com.laychv.common.TreeNode.stringToTreeNode;

/**
 * 层序遍历
 */
public class LevelOrder {

    public static void main(String[] args) {
        String x = "[3,9,20,null,null,15,7]";
        System.out.println("[[3],[9, 20],[15, 7]]->:");
        System.out.println(int2dListToString(levelOrder(stringToTreeNode(x))));
    }

    /**
     * bfs
     * Stack不适用
     * https://leetcode.cn/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

//        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();// ???
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < n; i++) { // error -> for (int i = 0;i < stack.size();i++){}
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(level);
        }

        return res;
    }
}
