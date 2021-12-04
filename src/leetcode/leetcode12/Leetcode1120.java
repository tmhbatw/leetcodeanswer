package leetcode.leetcode12;

import datastructure.TreeNode;

public class Leetcode1120 {

    double result=0.0;
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return result;
    }

    private int[] dfs(TreeNode root){
        if(root==null)
            return new int[]{0,0};

        int[] l=dfs(root.left);
        int[] r=dfs(root.right);
        int sum=l[0]+r[0]+root.val;
        int time=l[1]+r[1]+1;

        result=Math.max(result,sum*1.0/time);
        return new int[]{sum,time};
    }
}
