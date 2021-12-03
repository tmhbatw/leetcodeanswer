package leetcode.leetcode20;

import datastructure.TreeNode;

public class Leetcode1973 {

    int result=0;
    public int equalToDescendants(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root){
        if(root==null)
            return 0;
        int l=dfs(root.left);
        int r=dfs(root.right);

        if(l+r==root.val)
            result++;
        return root.val+l+r;
    }
}
