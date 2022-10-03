package com.laychv.leetcode.tree;

import com.laychv.common.TreeNode;

import static com.laychv.common.PrintTreeNode.stringToTreeNode;


/**
 * 222. 完全二叉树的节点个数
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~2h个节点。
 * <p>
 * 示例 1：
 * 1
 * /  \
 * 2    3
 * / \  /
 * 4   5 6
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * DFS深度优先
 */
class _222_CountCompleteTreeNodes {

    public static void main(String[] args) {
        String s = "[1,2,3,4,5,6]";
        TreeNode root = stringToTreeNode(s);
        int ret = new _222_CountCompleteTreeNodes().countNodes(root);
        String out = String.valueOf(ret);
        System.out.print(out);
    }

    public int countNodes(TreeNode root) {
        return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }
}