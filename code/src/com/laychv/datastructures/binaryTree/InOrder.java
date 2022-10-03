package com.laychv.datastructures.binaryTree;

import com.laychv.common.TreeNode;

import java.util.List;

import static com.laychv.common.PrintTreeNode.integerArrayListToString;
import static com.laychv.common.PrintTreeNode.stringToTreeNode;

/**
 * 中序遍历
 * 前中后序递归版简单很简洁
 */
public class InOrder {

    public static void main(String[] args) {
        String line = "[1,null,2,3]";
        TreeNode root = stringToTreeNode(line);
        List<Integer> ret = new PostOrder().postorderTraversal(root);
        String out = integerArrayListToString(ret);
        System.out.print(out);
    }


}
