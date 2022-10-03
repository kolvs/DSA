package com.laychv.leetcode.tree;

import com.laychv.common.TreeNode;

import static com.laychv.common.PrintTreeNode.stringToTreeNode;

/**
 * 111 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * <p>
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _111_MinimumDepthofBinaryTree {

    public static void main(String[] args) {

        String line = "[2,null,3,null,4,null,5,null,6]";
//        String line = "[3,9,20,null,null,15,7]";

        TreeNode root = stringToTreeNode(line);
        int ret = new _111_MinimumDepthofBinaryTree().minDepth(root);
        String out = String.valueOf(ret);
        System.out.print(out);
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
