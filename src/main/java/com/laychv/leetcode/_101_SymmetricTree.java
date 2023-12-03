package com.laychv.leetcode;

import com.laychv.common.TreeNode;

import java.util.LinkedList;

import static com.laychv.common.TreeNode.stringToTreeNode;

/**
 * 101. 对称二叉树 🟢
 * <p>
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * 提示：树中节点数目在范围 [1, 1000] 内 -100 <= Node.val <= 100
 * <p>
 * https://leetcode.cn/problems/symmetric-tree/
 */
public class _101_SymmetricTree {

    public static void main(String[] args) {
        System.out.println("true->:" + isSymmetric(stringToTreeNode("[1,2,2,3,4,4,3]")));
        System.out.println("true->:" + isSymmetric2(stringToTreeNode("[1,2,2,3,4,4,3]")));
        System.out.println("false->:" + isSymmetric(stringToTreeNode("[1,2,2,null,3,null,3]")));
        System.out.println("false->:" + isSymmetric2(stringToTreeNode("[1,2,2,null,3,null,3]")));
    }

    /**
     * dfs
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    private static boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false; // left == right
        if (left.val != right.val) return false;
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    /**
     * bfs
     */
    public static boolean isSymmetric2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;

        // 用队列保存节点 / ArrayDeque 报错
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 存入左右结点
        queue.add(root.left);
        queue.add(root.right);

        while (queue.size() > 0) {
            // 取出左右结点
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();

            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            queue.add(left.left);
            queue.add(right.right);

            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }
}
