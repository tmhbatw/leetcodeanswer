package leetcode.leetcode6;

import datastructure.TreeNode;

public class Leetcode538 {
    int big=0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root){
        if(root==null)
            return;
        dfs(root.right);
        big+=root.val;
        root.val=big;
        dfs(root.left);
    }
}
