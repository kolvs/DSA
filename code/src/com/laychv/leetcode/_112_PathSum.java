package com.laychv.leetcode;

import com.laychv.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static com.laychv.common.PrintSingleNode.booleanToString;
import static com.laychv.common.PrintTreeNode.stringToTreeNode;

/**
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明:叶子节点是指没有子节点的节点。
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 * <p>
 * https://leetcode-cn.com/problems/path-sum
 */
public class _112_PathSum {

    public static void main(String[] args) {
        String s = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
        int sum = 22;
        System.out.print(booleanToString(hasPathSum(stringToTreeNode(s), sum)));
        System.out.print(booleanToString(hasPathSum2(stringToTreeNode(s), sum)));
    }

    // 递归
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null || root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    // BFS
    public static boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        // queue
        Queue<TreeNode> qNode = new LinkedList<>();
        Queue<Integer> qValue = new LinkedList<>();
        // 添加根结点
        qNode.offer(root);
        // 添加根结点的值
        qValue.offer(root.val);
        //
        while (!qNode.isEmpty()) {
            TreeNode node = qNode.poll();
            Integer temp = qValue.poll();
            if (node.left == null && node.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (root.left != null) {
                qNode.offer(node.left);
                qValue.offer(node.left.val + temp);
            }
            if (root.right != null) {
                qNode.offer(node.right);
                qValue.offer(node.right.val + temp);
            }
        }
        return false;
    }
}
