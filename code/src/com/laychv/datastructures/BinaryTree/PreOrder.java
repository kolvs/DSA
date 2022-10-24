package com.laychv.datastructures.BinaryTree;

import com.laychv.common.TreeNode;

import java.util.*;

import static com.laychv.common.TreeNode.integerArrayListToString;
import static com.laychv.common.TreeNode.stringToTreeNode;

/**
 * 前序遍历
 * <p>
 * 递归 dfs
 * 迭代 bfs
 * Morris
 * <p>
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
 */
public class PreOrder {

    public static void main(String[] args) {
        String x = "[1,null,2,3]";
        System.out.println(integerArrayListToString(preorderTraversal(stringToTreeNode(x))));
        System.out.println(integerArrayListToString(preorderTraversal2(stringToTreeNode(x))));
        System.out.println(integerArrayListToString(preorderTraversal3(stringToTreeNode(x))));
    }

    // dfs == recursion
    static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return null;
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private static void preorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    // bfs == iterator + stack
    static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return res;
    }

    // morris
    static List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        TreeNode cur1 = root;
        TreeNode cur2 = null;

        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
//                    System.out.print(cur1.val + " ");
                    res.add(cur1.val);
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            } else {
                res.add(cur1.val);
//                System.out.print(cur1.val + " ");
            }
            cur1 = cur1.right;
        }

        return res;
    }
}
