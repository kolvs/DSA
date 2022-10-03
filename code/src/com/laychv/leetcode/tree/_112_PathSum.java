package com.laychv.leetcode.tree;

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
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 递归
 * 时间复杂度：O(N)
 * 空间复杂度：O(H) H树的高度
 * <p>
 * 广度优先搜索：BFS
 * <p>
 * 队列
 * <p>
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)
 */
public class _112_PathSum {

    public static void main(String[] args) {
        String s = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
        int sum = 22;
        TreeNode root = stringToTreeNode(s);
        boolean ret = new _112_PathSum().hasPathSum(root, sum);
        String out = booleanToString(ret);
        System.out.print(out);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null || root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
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
