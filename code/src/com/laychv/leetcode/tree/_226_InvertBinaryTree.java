package com.laychv.leetcode.tree;

import com.laychv.common.TreeNode;

import static com.laychv.common.PrintTreeNode.stringToTreeNode;
import static com.laychv.common.PrintTreeNode.treeNodeToString;

/**
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 * <p>
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 递归
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
class _226_InvertBinaryTree {
    public static void main(String[] args) {
        String line = "[4,2,7,1,3,6,9]";
        TreeNode root = stringToTreeNode(line);
        TreeNode ret = new _226_InvertBinaryTree().invertTree(root);
        String out = treeNodeToString(ret);
        System.out.print(out);
    }

    public TreeNode invertTree(TreeNode root) {
        // 终止条件
        if (root == null) {
            return null;
        }
        // 本级递归
        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        root.left = left;
        root.right = right;
        // 递归返回值
        return root;
    }
}