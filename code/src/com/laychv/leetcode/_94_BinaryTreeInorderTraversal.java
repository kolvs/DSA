package com.laychv.leetcode;

import com.laychv.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.laychv.common.PrintTreeNode.integerArrayListToString;
import static com.laychv.common.PrintTreeNode.stringToTreeNode;

/**
 * 94. 二叉树的中序遍历
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 */
public class _94_BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        String x = "[1,null,2,3]";
        System.out.println(integerArrayListToString(inorderTraversal(stringToTreeNode(x))));
        System.out.println(integerArrayListToString(inorderTraversal2(stringToTreeNode(x))));
        System.out.println(integerArrayListToString(inorderTraversal3(stringToTreeNode(x))));
    }

    // iterator
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    // recursion
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    // morris
    public static List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
