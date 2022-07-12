package leetcode.leetcode24;

import datastructure.TreeNode;

public class Leetcode2331 {


    public boolean evaluateTree(TreeNode root) {
        switch (root.val){
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return evaluateTree(root.left)||evaluateTree(root.right);
            default:
                return evaluateTree(root.left)&&evaluateTree(root.right);
        }
    }

}
