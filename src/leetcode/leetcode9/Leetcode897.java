package leetcode.leetcode9;

import datastructure.TreeNode;

public class Leetcode897 {

    TreeNode result=new TreeNode(0);
    TreeNode cur=result;

    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return result.right;
    }

    private void inOrder(TreeNode root){
        if(root==null)
            return;
        inOrder(root.left);
        cur.right=new TreeNode(root.val);
        cur=cur.right;
        inOrder(root.right);
    }
}
