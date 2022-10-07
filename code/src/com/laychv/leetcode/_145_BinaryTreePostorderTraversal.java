package com.laychv.leetcode;

import com.laychv.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static com.laychv.common.PrintTreeNode.integerArrayListToString;
import static com.laychv.common.PrintTreeNode.stringToTreeNode;

/**
 * 145. 二叉树的后序遍历
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 */
public class _145_BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        String x = "[1,null,2,3]";
        System.out.println(integerArrayListToString(postorderTraversal(stringToTreeNode(x))));
        System.out.println(integerArrayListToString(postorderTraversal2(stringToTreeNode(x))));
        System.out.println(integerArrayListToString(postorderTraversal3(stringToTreeNode(x))));
    }

    // iterator
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    // recursion
    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    static void postorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    // morris
    public static List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        TreeNode p1 = root, p2 = null;

        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                    addPath(res, p1.left);
                }
            }
            p1 = p1.right;
        }
        addPath(res, root);
        return res;
    }

    static void addPath(List<Integer> res, TreeNode root) {
        int count = 0;
        while (root != null) {
            ++count;
            res.add(root.val);
            root = root.right;
        }
        int left = res.size() - count, right = res.size() - 1;
        while (left < right) {
            int temp = res.get(left);
            res.set(left, res.get(right));
            res.set(right, temp);
            left++;
            right--;
        }
    }

}
