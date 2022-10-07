package com.laychv.datastructures.BinaryTree;

import com.laychv.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static com.laychv.common.PrintTreeNode.integerArrayListToString;
import static com.laychv.common.PrintTreeNode.stringToTreeNode;

/**
 * 中序遍历
 * 前中后序递归版简单很简洁
 */
public class InOrder {

    public static void main(String[] args) {
        String x = "[1,null,2,3]";
        System.out.println(integerArrayListToString(inorderTraversal(stringToTreeNode(x))));
    }

    static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return res;
    }

}
