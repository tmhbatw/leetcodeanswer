package leetcode.leetcode14;

import datastructure.TreeNode;

public class Leetcode1372 {

    int result=0;
    public int longestZigZag(TreeNode root) {
        getRes(root);
        return result;
    }

    private int[] getRes(TreeNode root){
        if(root==null)
            return new int[]{0,0};

        int[] left=getRes(root.left);
        int[] right=getRes(root.right);

        result=Math.max(result,left[1]);
        result=Math.max(result,right[0]);
        return new int[]{1+left[1],1+right[1]};
    }
}
