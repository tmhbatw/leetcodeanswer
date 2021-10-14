package leetcode.leetcode10;

import datastructure.TreeNode;

public class Leetcode965 {

    int val;


    public boolean isUnivalTree(TreeNode root) {
        if(root==null)
            return true;
        this.val=root.val;
        return inOrder(root);
    }

    private boolean inOrder(TreeNode root){
        if(root==null)
            return true;
        return root.val==val&&inOrder(root.left)&&inOrder(root.right);
    }
}
