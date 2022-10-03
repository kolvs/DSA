package com.laychv.leetcode.binaryTree;

import com.laychv.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static com.laychv.common.PrintIntegerArray.int2dListToString;
import static com.laychv.common.PrintTreeNode.stringToTreeNode;

/**
 * 102. 二叉树的层序遍历
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 */
public class _102_Binary_Tree_Level_Order_Traversal {

    public static void main(String[] args) {
        String line = "[3,9,20,null,null,15,7]";
        TreeNode root = stringToTreeNode(line);
        List<List<Integer>> ret = new _102_Binary_Tree_Level_Order_Traversal().levelOrder(root);
        String out = int2dListToString(ret);
        System.out.print(out);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
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
