package leetcode.leetcode10;

import datastructure.TreeNode;

public class Leetcode979 {

    int result=0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root){
        if(root==null)
            return 0;
        int l=dfs(root.left);
        int r=dfs(root.right);
        result+=Math.abs(l)+Math.abs(r);
        return l+r+root.val-1;
    }
}
