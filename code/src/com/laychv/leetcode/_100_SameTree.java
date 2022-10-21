package com.laychv.leetcode;

import com.laychv.common.TreeNode;

import static com.laychv.common.PrintTreeNode.stringToTreeNode;

/**
 * 100. 相同的树 🟢
 * <p>
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * <p>
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 * <p>
 * 提示：
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -10^4 <= Node.val <= 10^4
 * <p>
 * https://leetcode.cn/problems/same-tree/
 */
public class _100_SameTree {

    public static void main(String[] args) {
        System.out.println("true->:" + isSameTree(stringToTreeNode("[1,2,3]"), stringToTreeNode("[1,2,3]")));
        System.out.println("false->:" + isSameTree(stringToTreeNode("[1,2]"), stringToTreeNode("[1,null,2]")));
    }

    /**
     * dfs
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        // 判断其他节点是否相同
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
