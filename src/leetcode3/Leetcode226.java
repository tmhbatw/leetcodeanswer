package leetcode3;

import datastructure.TreeNode;

public class Leetcode226 {
    /*Description
    * 翻转一棵二叉树。
    * */

    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode right=invertTree(root.right);
        TreeNode left=invertTree(root.left);
        root.left=right;
        root.right=left;
        return root;
    }
}
