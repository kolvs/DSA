package com.laychv.leetcode.tree.PathSum;

import com.laychv.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先搜索：BFS
 * <p>
 * 队列
 * <p>
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)
 */
public class Solution2 {

    public boolean hasPathSum(TreeNode root, int sum) {
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
