package leetcode.leetcode2;

import datastructure.TreeNode;

public class Leetcode114 {
    /*Description
    * 给定一个二叉树，原地将它展开为一个单链表。
    * */

    public void flatten(TreeNode root) {
        if(root==null)
            return ;
        TreeNode left=root.left;
        TreeNode right=root.right;
        TreeNode result=root;
        result.left=null;
        flatten(left);
        root.right=left;
        while(root.right!=null)
            root=root.right;
        flatten(right);
        root.right=right;
    }
}
