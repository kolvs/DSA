package com.laychv.datastructures.BinaryTree;

import com.laychv.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static com.laychv.common.PrintIntegerArray.int2dListToString;
import static com.laychv.common.PrintTreeNode.stringToTreeNode;

/**
 * 层序遍历
 */
public class LevelOrder {

    public static void main(String[] args) {
        String x = "[3,9,20,null,null,15,7]";
        System.out.println(int2dListToString(levelOrder(stringToTreeNode(x))));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        return res;
    }
}
