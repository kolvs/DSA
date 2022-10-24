package com.laychv.leetcode;

import com.laychv.common.TreeNode;

import static com.laychv.common.TreeNode.stringToTreeNode;
import static com.laychv.common.TreeNode.treeNodeToString;

/**
 * 🔒156. 上下翻转二叉树 🟧
 * <p>
 * 给定一个二叉树，其中所有的右节点要么是具有兄弟节点（拥有相同父节点的左节点）的叶节点，
 * 要么为空，将此二叉树上下翻转并将它变成一棵树， 原来的右节点将转换成左叶节点。返回新的根。
 * <p>
 * Given a binary tree where all the right nodes are either leaf nodes with
 * a sibling (a left node that shares the same parent node) or empty,
 * flip it upside down and turn it into a tree where the original
 * right nodes turned into left leaf nodes. Return the new root.
 * <p>
 * Input: [1,2,3,4,5]
 * -----1
 * ----/-\
 * ---2---3
 * --/-\
 * -4---5
 * Output: return the root of the binary tree [4,5,2,#,#,3,1]
 * -----4
 * ----/-\
 * ---5---2
 * ------/-\
 * -----3---1
 * <p>
 * https://leetcode.cn/problems/binary-tree-upside-down/
 * https://leetcode.com/problems/binary-tree-upside-down/
 */
public class _156_BinaryTreeUpsideDown {

    public static void main(String[] args) {
        System.out.println(treeNodeToString(upsideDownBinaryTree(stringToTreeNode("[1,2,3,4,5]"))));
        System.out.println(treeNodeToString(upsideDownBinaryTree2(stringToTreeNode("[1,2,3,4,5]"))));
    }

    // https://segmentfault.com/a/1190000016755610

    // dfs
    public static TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;

        //递归调用得到新的root，并且沿途改变结构。
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        //千万记得将root node 的左右两边设为null
        root.left = null;
        root.right = null;
        return newRoot;
    }

    // bfs
    public static TreeNode upsideDownBinaryTree2(TreeNode root) {
        //iterative
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode next = null;
        TreeNode temp = null;

        while (curr != null) {
            next = curr.left;
            //swap nodes, we need to keep a temp to track the right node
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }
}
