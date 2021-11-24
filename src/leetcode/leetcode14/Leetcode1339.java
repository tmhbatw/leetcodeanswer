package leetcode.leetcode14;

import datastructure.TreeNode;

public class Leetcode1339 {

    long result=0;
    int val;
    public int maxProduct(TreeNode root) {
        val=changeTreeNode(root);
        dfs(root);
        return (int) (result%1000000007);
    }

    private void dfs(TreeNode root){
        if(root.left!=null){
            int left=root.left.val;
            result=Math.max((long) (val - left) *left,result);
            dfs(root.left);
        }
        if(root.right!=null){
            int right=root.right.val;
            result=Math.max((long)(val-right)*right,result);
            dfs(root.right);
        }
    }

    private int changeTreeNode(TreeNode root){
        if(root==null)
            return 0;
        int left=changeTreeNode(root.left);
        int right=changeTreeNode(root.right);
        root.val+=left+right;
        return root.val;
    }
}
